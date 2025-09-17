/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;

import compuwork.models.Departamento;
import compuwork.models.Empleado;
import compuwork.models.Permanente;
import compuwork.models.Temporal;
import compuwork.models.ReporteDesempeno;
import compuwork.models.TipoReportes;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.LinkedList;

public class systemController {

    private ArrayList<Departamento> departamentos;
    private ArrayList<Empleado> empleados;
    private ArrayList<ReporteDesempeno> reportes;

    public systemController() {
        this.departamentos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }

    // Departamentos
    public void crearDepartamento(int idDepartamento, String nombre, String descripcion, LinkedList<Empleado> empleado) {
        Departamento d = new Departamento(idDepartamento, nombre, descripcion, empleado);
        departamentos.add(d);
    }

    public ArrayList<Departamento> listarDepartamentos() {
        return departamentos;
    }

    // Empleados
    public Empleado crearEmpleadoPermanente(String planBeneficios, int idEmpleado, String nombre, String apellido, int documento, LocalDate fechaVinculacion, LocalDate fechaIngreso, String tipo_empleado, double salario) {
        Empleado e = new Permanente(planBeneficios, idEmpleado, nombre, apellido, documento, fechaVinculacion, fechaIngreso, tipo_empleado, salario);
        empleados.add(e);
        return e;
    }

    public Empleado crearEmpleadoTemporal(LocalDate fechaCulminacion, int idEmpleado, String nombre, String apellido, int documento, LocalDate fechaVinculacion, LocalDate fechaIngreso, String tipo_empleado, double salario) {
        Empleado e = new Temporal(fechaCulminacion, idEmpleado, nombre, apellido, documento, fechaVinculacion, fechaIngreso, tipo_empleado, salario);
        empleados.add(e);
        return e;
    }

    public void asignarEmpleadoADepartamento(Empleado emp, Departamento depto) {
        depto.agregarEmpleado(emp);
    }

    // Reportes
    public ReporteDesempeno generarReporte(int idReporte, LocalDate fechaGeneracion, TipoReportes tipoReporte, String metricas) {
        ReporteDesempeno r = new ReporteDesempeno(idReporte, fechaGeneracion, tipoReporte, metricas);
        reportes.add(r);
        return r;
    }

    public ArrayList<ReporteDesempeno> listarReportes() {
        return reportes;
    }
}
