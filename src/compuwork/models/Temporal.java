/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
import java.time.LocalDate;
/**
 *
 * @author user
 */
public class Temporal extends Empleado{
    private LocalDate fechaCulminacion;

    public Temporal() {
        
    }

    public Temporal(LocalDate fechaCulminacion, int idEmpleado, String nombre, String apellido, int documento, LocalDate fechaVinculacion, LocalDate fechaIngreso, String tipo_empleado, double salario) {
        super(idEmpleado, nombre, apellido, documento, fechaVinculacion, fechaIngreso, tipo_empleado, salario);
        this.fechaCulminacion = fechaCulminacion;
    }


    public LocalDate getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(LocalDate fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }
    
    //Porque no tiene plan de beneficios.
    public double calcularPago() {
    return getSalario();
    }
    
}
