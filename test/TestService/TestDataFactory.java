/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import compuwork.models.Departamento;
import compuwork.models.Empleado;
import java.time.LocalDate;

public final class TestDataFactory {
    private TestDataFactory() {}

    public static Empleado empleado(String nombre, int documento) {
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido("Prueba");
        empleado.setDocumento(documento);            // int
        empleado.setFechaVinculacion(LocalDate.now());
        empleado.setFechaIngreso(LocalDate.now());
        empleado.setTipo_empleado("Permanente");
        empleado.setSalario(1_000_000.0);
        return empleado;
    }

    public static Departamento departamento(String nombre) {
        Departamento departamento = new Departamento();
        departamento.setNombre(nombre);
        departamento.setDescripcion("Depto de pruebas");
        try { departamento.setNumeroEmpleados(0); } catch (Throwable ignore) {}
        // Si tu clase tiene setId(int), descomenta:
        // try { d.setId(id); } catch (Throwable ignore) {}
        return departamento;
    }
}