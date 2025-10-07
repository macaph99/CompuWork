package compuwork.controller;

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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        try {
            sistema.eliminarEmpleado(id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public boolean eliminarPorDocumento(long documento) {
    try {
        for (Empleado empleado : sistema.listarEmpleados()) {
            if (empleado.getDocumento() == documento) {
                return sistema.eliminarEmpleado(empleado.getIdEmpleado());
            }
        }
    } catch (Exception e) {
        System.out.println("Error eliminando empleado: " + e.getMessage());
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
            for (Empleado empleado : lista) {
                System.out.println(empleado);
            }
        }
    }

    public void asignarADepartamento(int idEmpleado, int idDepartamento) {
        try {
            sistema.asignarEmpleadoADepartamento(idEmpleado, idDepartamento);
        } catch (Exception e) {
            System.out.println("Error asignando empleado a departamento: " + e.getMessage());
        }
    }


    public boolean eliminarPorDocumento(Long documento) {
        List<Empleado> lista = sistema.listarEmpleados();
        for (Empleado empleado : lista) {
            if (empleado.getDocumento() == documento) {
                try {
                    sistema.eliminarEmpleado(empleado.getIdEmpleado());
                    return true;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return false;
    }
}
