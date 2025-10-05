package compuwork.service;

import compuwork.exception.AsignacionException;
import compuwork.exception.NotFoundException;
import compuwork.models.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
    private final List<Empleado> empleados = new ArrayList<>();
    private final List<Departamento> departamentos = new ArrayList<>();

    public void registrarDepartamento(Departamento departamento) {
        if (departamento != null && !departamentos.contains(departamento)) {
            departamentos.add(departamento);
        }
    }

    public void registrarEmpleado(Empleado empleado) {
        if (empleado != null && !empleados.contains(empleado)) {
            empleados.add(empleado);
        }
    }

    public Empleado buscarEmpleado(int id) throws NotFoundException {
        return empleados.stream()
                .filter(e -> e.getIdEmpleado() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Empleado id=" + id + " no encontrado"));
    }

    public List<Empleado> listarEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    public Departamento buscarDepartamento(int id) throws NotFoundException {
        return departamentos.stream()
                .filter(d -> d.getIdDepartamento() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Departamento id=" + id + " no encontrado"));
    }

    public List<Departamento> listarDepartamentos() {
        return Collections.unmodifiableList(departamentos);
    }

    public boolean eliminarEmpleado(int id) throws NotFoundException {
        Empleado empleado = buscarEmpleado(id);
        if (empleado.getDepartamento() != null) {
            empleado.getDepartamento().removerEmpleado(empleado);
        }
        return empleados.remove(empleado);
    }

    public boolean eliminarDepartamento(int id) throws NotFoundException {
        Departamento departamento = buscarDepartamento(id);
        for (Empleado e : new ArrayList<>(departamento.getEmpleados())) {
            departamento.removerEmpleado(e);
        }
        return departamentos.remove(departamento);
    }

    public void asignarEmpleadoADepartamento(int idEmpleado, int idDepartamento)
            throws NotFoundException, AsignacionException {
        Empleado empleado = buscarEmpleado(idEmpleado);
        Departamento nuevo = buscarDepartamento(idDepartamento);
        if (empleado.getDepartamento() != null) {
            empleado.getDepartamento().removerEmpleado(empleado);
        }
        nuevo.agregarEmpleado(empleado);
        empleado.setDepartamento(nuevo);
    }

    public ReporteDesempeno reporteEmpleado(int idEmpleado) throws NotFoundException {
        Empleado empleado = buscarEmpleado(idEmpleado);
        ReporteDesempeno reporte = new ReporteDesempeno(TipoReportes.INDIVIDUAL);
        reporte.setMetricas(ReporteDesempeno.generarReporteEmpleado(empleado));
        return reporte;
    }

    public ReporteDesempeno reporteDepartamento(int idDepartamento) throws NotFoundException {
        Departamento departamento = buscarDepartamento(idDepartamento);
        ReporteDesempeno reporte = new ReporteDesempeno(TipoReportes.DEPARTAMENTO);
        reporte.setMetricas(ReporteDesempeno.generarReporteDepartamento(departamento));
        return reporte;
    }
}
