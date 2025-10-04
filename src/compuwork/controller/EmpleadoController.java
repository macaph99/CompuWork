/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.controller;

import compuwork.exception.CompuExceptions;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmpleadoController {

    private final List<Empleado> empleados = new ArrayList<>();
    private final Sistema sistema;

    public EmpleadoController(Sistema sistema) {
        this.sistema = sistema;
    }

    public void registrar(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado nulo");
        }
        empleados.add(empleado);
        try {
            sistema.registrarEmpleado(empleado);
            System.out.println("Empleado registrado.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void eliminar(int id) {
        try {
            sistema.eliminarEmpleado(id);
            System.out.println("Empleado eliminado.");
        } catch (CompuExceptions ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void listar() {
        List<Empleado> l = sistema.listarEmpleados();
        if (l.isEmpty()) {
            System.out.println("No hay empleados.");
        }
        for (Empleado e : l) {
            System.out.println(e);
        }
    }

    public List<Empleado> getEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    // import java.util.Iterator;
    public boolean eliminarPorDocumento(Long documento) {
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado e = it.next();
            if (e.getDocumento() == (documento)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

}
