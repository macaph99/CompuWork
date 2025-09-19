/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
import java.time.LocalDate;

public class Empleado {
  
    private static int contadorEmpleado = 1;
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private long documento;
    private LocalDate fechaVinculacion;    
    private LocalDate fechaIngreso;       
    private String tipo_empleado;          
    private double salario;
    private Departamento departamento;    
    private boolean activo = true;
    
    private double indiceDesempeno = 1 + Math.random() * 9;

   
    public Empleado() {
        this.idEmpleado = contadorEmpleado++;
    }

    public Empleado(String nombre, String apellido, long documento, LocalDate fechaIngreso, double salario, String tipo_empleado) { 
        this.idEmpleado = contadorEmpleado++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.fechaVinculacion = fechaIngreso;  
        this.salario = salario;
        this.tipo_empleado = tipo_empleado;
    }

   
    public int getIdEmpleado() { 
        return idEmpleado; 
    }
    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    public String getApellido() { 
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public long getDocumento() {
        return documento; 
    }
    public void setDocumento(int documento) { 
        this.documento = documento; 
    }
    public LocalDate getFechaVinculacion() { 
        return fechaVinculacion; 
    }
    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
    public LocalDate getFechaIngreso() { 
        return fechaIngreso; 
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso; 
    }
    public String getTipo_empleado() {
        return tipo_empleado; 
    }
    public void setTipo_empleado(String tipo_empleado) { 
        this.tipo_empleado = tipo_empleado;
    }
    public double getSalario() {
        return salario; 
    }
    public void setSalario(double salario) {
        this.salario = salario; 
    }
    public Departamento getDepartamento() { 
        return departamento;
    }
    public void setDepartamento(Departamento departamento) { 
        this.departamento = departamento; 
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    public double calcularIndiceDesempeno() {
        return indiceDesempeno;
    }

    @Override
    public String toString() {
        String dep = (departamento == null) ? "Sin departamento"
                : departamento.getNombre() + " (id=" + departamento.getIdDepartamento() + ")";
        return "EMPLEADO " + idEmpleado + "\n" +
           "Nombre: " + nombre + "\n" +
           "Apellido: " + apellido + "\n" +
           "Documento: " + documento + "\n" +
           "Fecha vinculación: " + fechaVinculacion + "\n" +
           "Fecha ingreso: " + fechaIngreso + "\n" +
           "Tipo empleado: " + tipo_empleado + "\n" +
           "Salario: " + salario + "\n" +
           "Activo: " + activo + "\n" +
           "Departamento: " + dep + "\n" +
           "Índice de desempeño: " + String.format("%.2f", indiceDesempeno) + "\n";
    }
}
