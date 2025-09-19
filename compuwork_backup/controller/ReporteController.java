/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;
import compuwork.exception.CompuExceptions;
import compuwork.models.ReporteDesempeno;
import compuwork.service.Sistema;

public class ReporteController {
    private final Sistema sistema;
    public ReporteController(Sistema s){ 
        this.sistema = s; 
    }

    public void empleado(int idEmpleado){
        try { 
            ReporteDesempeno r = sistema.reporteEmpleado(idEmpleado); 
            r.mostrarReporte(); 
        }
        catch (CompuExceptions ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
    public void departamento(int idDepartamento){
        try { 
            ReporteDesempeno r = sistema.reporteDepartamento(idDepartamento); 
            r.mostrarReporte(); 
        }
        catch (CompuExceptions ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
}