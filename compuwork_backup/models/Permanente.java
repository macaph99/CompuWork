/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
import java.time.LocalDate;

public class Permanente extends Empleado {
    private String planBeneficios;

    public Permanente() { 
        super(); 
        setTipo_empleado("Permanente"); 
    }

    public Permanente(String nombre, String apellido, int documento, LocalDate fechaIngreso, double salario, LocalDate fechaVinculacion, String planBeneficios) {
        super(nombre, apellido, documento, fechaIngreso, salario, "Permanente");
        setFechaVinculacion(fechaVinculacion);
        this.planBeneficios = planBeneficios;
    }

    public String getPlanBeneficios() { 
        return planBeneficios; 
    }
    
    public void setPlanBeneficios(String planBeneficios) { 
        this.planBeneficios = planBeneficios; 
    }

    public boolean renunciar() { 
        setActivo(false); 
        return true; 
    }

    @Override
    public String toString() {
        return super.toString() + " [Permanente: planBeneficios='" + planBeneficios + "']";
    }
}