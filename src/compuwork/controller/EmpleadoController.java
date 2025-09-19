/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;
import compuwork.exception.CompuExceptions;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.List;

public class EmpleadoController {
    private final Sistema sistema;
    public EmpleadoController(Sistema s){ this.sistema = s; }

    public void registrar(Empleado e){
        try { 
            sistema.registrarEmpleado(e); 
            System.out.println("Empleado registrado."); 
        }
        catch (Exception ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
    public void eliminar(int id){
        try { sistema.eliminarEmpleado(id); 
        System.out.println("Empleado eliminado."); 
        }
        catch (CompuExceptions ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
    public void listar(){
        List<Empleado> l = sistema.listarEmpleados();
        if(l.isEmpty()) System.out.println("No hay empleados.");
        for(Empleado e: l) System.out.println(e);
    }
}