/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.service;
import compuwork.exception.AsignacionException;
import compuwork.exception.NotFoundException;
import compuwork.models.*;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private final List<Empleado> empleados = new ArrayList<>();
    private final List<Departamento> departamentos = new ArrayList<>();

    public void registrarDepartamento(Departamento d) { if (d!=null && !departamentos.contains(d)) departamentos.add(d); }
    public void registrarEmpleado(Empleado e) { if (e!=null && !empleados.contains(e)) empleados.add(e); }

    public Empleado buscarEmpleado(int id) throws NotFoundException {
        return empleados.stream().filter(x -> x.getIdEmpleado()==id)
                .findFirst().orElseThrow(() -> new NotFoundException("Empleado id="+id+" no encontrado"));
    }
    
    public Departamento buscarDepartamento(int id) throws NotFoundException {
        return departamentos.stream().filter(x -> x.getIdDepartamento()==id)
                .findFirst().orElseThrow(() -> new NotFoundException("Departamento id="+id+" no encontrado"));
    }

    public List<Empleado> listarEmpleados(){ return new ArrayList<>(empleados); }
    public List<Departamento> listarDepartamentos(){ return new ArrayList<>(departamentos); }

    public boolean eliminarEmpleado(int id) throws NotFoundException {
        Empleado e = buscarEmpleado(id);
        if (e.getDepartamento()!=null) e.getDepartamento().removerEmpleado(e);
        return empleados.remove(e);
    }
    
    public boolean eliminarDepartamento(int id) throws NotFoundException {
        Departamento d = buscarDepartamento(id);
        for (Empleado e : new ArrayList<>(d.getEmpleados())) d.removerEmpleado(e);
        return departamentos.remove(d);
    }

    public void asignarEmpleadoADepartamento(int idEmpleado, int idDepartamento)
            throws NotFoundException, AsignacionException {
        Empleado e = buscarEmpleado(idEmpleado);
        Departamento d = buscarDepartamento(idDepartamento);
        if (!e.isActivo()) throw new AsignacionException("No se puede asignar un empleado inactivo.");
        if (e.getDepartamento()!=null && e.getDepartamento()!=d) e.getDepartamento().removerEmpleado(e);
        d.agregarEmpleado(e);
    }

    public ReporteDesempeno reporteEmpleado(int idEmpleado) throws NotFoundException {
        Empleado e = buscarEmpleado(idEmpleado);
        ReporteDesempeno r = new ReporteDesempeno(TipoReportes.INDIVIDUAL);
        r.setMetricas(ReporteDesempeno.generarReporteEmpleado(e));
        return r;
    }
    
    public ReporteDesempeno reporteDepartamento(int idDepartamento) throws NotFoundException {
        Departamento d = buscarDepartamento(idDepartamento);
        ReporteDesempeno r = new ReporteDesempeno(TipoReportes.DEPARTAMENTO);
        r.setMetricas(ReporteDesempeno.generarReporteDepartamento(d));
        return r;
    }
}