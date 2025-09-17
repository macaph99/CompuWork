/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author user
 */
public class Permanente extends Empleado{
    private String planBeneficios;

    public Permanente() {
    }

    public Permanente(String planBeneficios, int idEmpleado, String nombre, String apellido, int documento, LocalDate fechaVinculacion, LocalDate fechaIngreso, String tipo_empleado, double salario) {
        super(idEmpleado, nombre, apellido, documento, fechaVinculacion, fechaIngreso, tipo_empleado, salario);
        if(planBeneficios == null || planBeneficios.isEmpty()) {
            throw new IllegalArgumentException("Plan de beneficios no puede ser vacío");
        }
        this.planBeneficios = planBeneficios;
    }

    public String getPlanBeneficios() {
        return planBeneficios;
    }

    public void setPlanBeneficios(String planBeneficios) {
        this.planBeneficios = planBeneficios;
    }
    
    //El period.between es usado para sacar la diferencia en  años.
    public double calcularPago(){
        int antiguedad = Period.between(getFechaIngreso(), LocalDate.now()).getYears();
        
        if (antiguedad < 0) {
        antiguedad = 0;
    }

    // el plan de beneficio es que por año cumplido aumente un 5%el salario
    double incremento = getSalario() * (antiguedad * 0.05);

    return getSalario() + incremento;
        
    }
    
}
