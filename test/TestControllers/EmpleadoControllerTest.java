/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestControllers;

import TestService.TestDataFactory;
import compuwork.controller.EmpleadoController;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class EmpleadoControllerTest {
    private Sistema sistema;
    private EmpleadoController ctrl;

    @Before public void setUp() {
        sistema = new Sistema();
        ctrl = new EmpleadoController(sistema);
    }

    @Test public void registrarEmpleados() {
        Empleado empleado = TestDataFactory.empleado("Ana", 123456);
        ctrl.registrar(empleado);
        assertTrue(sistema.listarEmpleados().contains(empleado));
    }

    @Test public void eliminarPorDocumento() throws Exception {
        Empleado empleado = TestDataFactory.empleado("Luis", 987654);
        sistema.registrarEmpleado(empleado);
        assertTrue(ctrl.eliminarPorDocumento(987654L));
        assertFalse(sistema.listarEmpleados().contains(empleado));
    }

    @Test public void listarEmpleados() {
        assertEquals(0, ctrl.getEmpleados().size());
    }
}
