/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;
import compuwork.service.Sistema;

public class AsignacionController {
    private final Sistema sistema;
    
    public AsignacionController(Sistema s){ 
        this.sistema = s; 
    }

    public void asignar(int idEmpleado, int idDepartamento){
        try { 
            sistema.asignarEmpleadoADepartamento(idEmpleado, idDepartamento); 
            System.out.println("Asignación realizada."); 
        }
        catch (Exception ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
}

