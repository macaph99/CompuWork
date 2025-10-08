/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestControllers;

import TestService.TestDataFactory;
import compuwork.models.Departamento;
import compuwork.service.Sistema;
import compuwork.controller.DepartamentoController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DepartamentoControllerTest {
    private Sistema sistema;
    private DepartamentoController ctrl;

    @Before public void setUp() {
        sistema = new Sistema();
        ctrl = new DepartamentoController(sistema);
    }

    @Test public void registrarDepartamento() {
        Departamento departamento = TestDataFactory.departamento("TI");
        ctrl.registrar(departamento);
        assertTrue(sistema.listarDepartamentos().contains(departamento));
    }

    @Test public void eliminarPorNombre() throws Exception {
        Departamento d = TestDataFactory.departamento("Ventas");
        sistema.registrarDepartamento(d);
        assertTrue(ctrl.eliminarPorNombre("Ventas"));
        assertFalse(sistema.listarDepartamentos().contains(d));
    }

    @Test public void listarDepartamento() {
        assertEquals(0, ctrl.getDepartamentos().size());
    }
}