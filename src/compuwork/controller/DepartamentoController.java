/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;
import compuwork.exception.CompuExceptions;
import compuwork.models.Departamento;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.List;

public class DepartamentoController {
    private final Sistema sistema;
    private final java.util.List<Departamento> departamentos = new java.util.ArrayList<>();
    
    public DepartamentoController(Sistema sistema){ 
        this.sistema = sistema; 
    }

    public void registrar(Departamento departamento){ 
        sistema.registrarDepartamento(departamento); 
        System.out.println("Departamento registrado."); 
    }

    public void eliminar(int id){
        try { 
            sistema.eliminarDepartamento(id); 
            System.out.println("Departamento eliminado."); 
        }
        catch (CompuExceptions ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
    
    public boolean eliminarPorNombre(String nombre) {
    return departamentos.removeIf(d -> nombre != null && nombre.equals(d.getNombre()));
}
    
    public void listar(){
        List<Departamento> l = sistema.listarDepartamentos();
        if(l.isEmpty()) System.out.println("No hay departamentos.");
        for(Departamento d: l) System.out.println(d);
    }
    
    public void listarEmpleados(int idDepartamento){
        try {
            Departamento d = sistema.buscarDepartamento(idDepartamento);
            System.out.println("Empleados de " + d.getNombre() + ":");
            if(d.getEmpleados().isEmpty()) System.out.println("(sin empleados)");
            for (Empleado e : d.getEmpleados()) System.out.println(" - " + e);
        } catch (CompuExceptions ex){ 
            System.out.println("Error: "+ex.getMessage()); 
        }
    }
    
    public java.util.List<Departamento> getDepartamentos() {
    return java.util.Collections.unmodifiableList(departamentos);
    }
}