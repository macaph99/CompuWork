/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import static TestService.TestDataFactory.empleado;
import compuwork.models.Departamento;
import compuwork.models.Empleado;
import compuwork.service.Sistema;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

    private Sistema sistema;

    @Before
    public void setUp() {
        sistema = new Sistema();
    }

    // ---------- EMPLEADOS ----------
    @Test
    public void al_iniciar_lista_empleados_vacia() {
        assertTrue(sistema.listarEmpleados().isEmpty());
    }

    @Test
    public void registrarEmpleado_agregaALaLista() {
        Empleado empleado = empleado("Ana", 123456); 
        sistema.registrarEmpleado(empleado);

        List<Empleado> lista = sistema.listarEmpleados();
        boolean existe = lista.stream().anyMatch(x -> x.getDocumento() == 123456);
        assertTrue("Debe aparecer un empleado con doc 123456", existe);
    }

    @Test
    public void eliminarEmpleadoPorDocumento_lo_quita() throws Exception {
        Empleado empleado = empleado("Luis", 987654); 
        sistema.registrarEmpleado(empleado);

        boolean ok = sistema.eliminarEmpleadoPorDocumento(987654);
        assertTrue("Debe devolver true al eliminar", ok);

        boolean sigue = sistema.listarEmpleados()
                .stream().anyMatch(x -> x.getDocumento() == 987654);
        assertFalse("No debe seguir en la lista", sigue);
    }

    // ---------- DEPARTAMENTOS ----------
    @Test
    public void al_iniciar_lista_departamentos_vacia() {
        assertTrue(sistema.listarDepartamentos().isEmpty());
    }

    @Test
    public void registrarDepartamento_agregaALaLista() {
        Departamento departamento = TestDataFactory.departamento("Sistemas");
        sistema.registrarDepartamento(departamento);

        boolean existe = sistema.listarDepartamentos()
                .stream().anyMatch(x -> "Sistemas".equals(x.getNombre()));
        assertTrue("Debe aparecer el departamento 'Sistemas'", existe);
    }

    @Test
    public void eliminarDepartamento_porId_lo_quita() throws Exception {
        Departamento departamento = TestDataFactory.departamento("Ventas");
        sistema.registrarDepartamento(departamento);

        Departamento guardado = sistema.listarDepartamentos().stream()
                .filter(x -> "Ventas".equals(x.getNombre()))
                .findFirst().orElseThrow();

        int id;
        try {
            id = (int) guardado.getClass().getMethod("getId").invoke(guardado);
        } catch (NoSuchMethodException nsme) {
            id = (int) guardado.getClass().getMethod("getIdDepartamento").invoke(guardado);
        }

        boolean ok = sistema.eliminarDepartamento(id);
        assertTrue("Debe eliminar por id interno", ok);

        boolean sigue = sistema.listarDepartamentos()
                .stream().anyMatch(x -> "Ventas".equals(x.getNombre()));
        assertFalse("No debe seguir 'Ventas' en la lista", sigue);
    }
}
