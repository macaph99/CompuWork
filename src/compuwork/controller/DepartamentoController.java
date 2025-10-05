package compuwork.controller;

import compuwork.exception.CompuExceptions;
import compuwork.models.Departamento;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.List;

public class DepartamentoController {
    private final Sistema sistema;

    public DepartamentoController(Sistema sistema) {
        this.sistema = sistema;
    }

    public void registrar(Departamento departamento) {
        sistema.registrarDepartamento(departamento);
    }

    public List<Departamento> getDepartamentos() {
        return sistema.listarDepartamentos();
    }

    public Departamento buscar(int id) throws CompuExceptions {
        return sistema.buscarDepartamento(id);
    }

    public void eliminar(int id) {
        try {
            sistema.eliminarDepartamento(id);
        } catch (CompuExceptions ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public boolean eliminarPorNombre(String nombre) {
        try {
            for (Departamento d : sistema.listarDepartamentos()) {
                if (nombre != null && nombre.equals(d.getNombre())) {
                    return sistema.eliminarDepartamento(d.getIdDepartamento());
                }
            }
        } catch (CompuExceptions ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }

    public void listar() {
        List<Departamento> lista = sistema.listarDepartamentos();
        if (lista.isEmpty()) System.out.println("No hay departamentos.");
        for (Departamento d : lista) System.out.println(d);
    }

    public void listarEmpleados(int idDepartamento) {
        try {
            Departamento departamento = sistema.buscarDepartamento(idDepartamento);
            System.out.println("Empleados de " + departamento.getNombre() + ":");
            if (departamento.getEmpleados().isEmpty()) System.out.println("(sin empleados)");
            for (Empleado empleado : departamento.getEmpleados()) System.out.println(" - " + empleado);
        } catch (CompuExceptions ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
