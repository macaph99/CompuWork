/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Departamento {
    private static int contadorDepartamento = 1;

    private int idDepartamento;
    private String nombre;
    private String descripcion;
    private int numeroEmpleados;
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() {
        this.idDepartamento = contadorDepartamento++; 
    }
    public Departamento(String nombre, String descripcion) {
        this(); this.nombre = nombre; 
        this.descripcion = descripcion; 
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }
    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
    
    
    public List<Empleado> getEmpleados() { 
        return Collections.unmodifiableList(empleados); 
    }

    public void agregarEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) { empleados.add(empleado); empleado.setDepartamento(this); }
    }
    
    public void removerEmpleado(Empleado empleado) {
        if (empleados.remove(empleado)) { empleado.setDepartamento(null); }
    }
    
    @Override
    public String toString() {
        return "DEPARTAMENTO " + idDepartamento + "\n" +
               "Nombre: " + nombre + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Número de empleados: " + empleados.size() + "\n";
    }
}

