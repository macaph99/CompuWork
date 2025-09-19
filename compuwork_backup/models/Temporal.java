/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
import java.time.LocalDate;

public class Temporal extends Empleado {
    private LocalDate fechaCulminacion;

    public Temporal() { 
        super(); setTipo_empleado("Temporal"); 
    }

    public Temporal(String nombre, String apellido, int documento, LocalDate fechaIngreso, double salario, LocalDate fechaVinculacion, LocalDate fechaCulminacion) {
        super(nombre, apellido, documento, fechaIngreso, salario, "Temporal");
        setFechaVinculacion(fechaVinculacion);
        this.fechaCulminacion = fechaCulminacion;
    }

    public LocalDate getFechaCulminacion() { 
        return fechaCulminacion; 
    }
    
    public void setFechaCulminacion(LocalDate fechaCulminacion) { 
        this.fechaCulminacion = fechaCulminacion; 
    }

    @Override
    public String toString() {
        return super.toString() + " [Temporal: culminación=" + fechaCulminacion + "]";
    }
}