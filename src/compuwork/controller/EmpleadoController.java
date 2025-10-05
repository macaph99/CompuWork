package compuwork.controller;

import compuwork.exception.CompuExceptions;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.List;

public class EmpleadoController {

    private final Sistema sistema;

    public EmpleadoController(Sistema sistema) {
        this.sistema = sistema;
    }

    public void registrar(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado nulo");
        }
        try {
            sistema.registrarEmpleado(empleado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void eliminar(int id) {
        try {
            sistema.eliminarEmpleado(id);
        } catch (CompuExceptions ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public boolean eliminarPorDocumento(long documento) {
    try {
        for (Empleado e : sistema.listarEmpleados()) {
            if (e.getDocumento() == documento) {
                return sistema.eliminarEmpleado(e.getIdEmpleado());
            }
        }
    } catch (Exception ex) {
        System.out.println("Error eliminando empleado: " + ex.getMessage());
    }
    return false;
}

    public List<Empleado> getEmpleados() {
        return sistema.listarEmpleados();
    }

    public void listar() {
        List<Empleado> lista = sistema.listarEmpleados();
        if (lista.isEmpty()) {
            System.out.println("No hay empleados.");
        } else {
            for (Empleado e : lista) {
                System.out.println(e);
            }
        }
    }

    public void asignarADepartamento(int idEmpleado, int idDepartamento) {
        try {
            sistema.asignarEmpleadoADepartamento(idEmpleado, idDepartamento);
        } catch (Exception ex) {
            System.out.println("Error asignando empleado a departamento: " + ex.getMessage());
        }
    }


    public boolean eliminarPorDocumento(Long documento) {
        List<Empleado> lista = sistema.listarEmpleados();
        for (Empleado e : lista) {
            if (e.getDocumento() == documento) {
                try {
                    sistema.eliminarEmpleado(e.getIdEmpleado());
                    return true;
                } catch (CompuExceptions ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return false;
    }
}
