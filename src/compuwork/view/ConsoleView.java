/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.view;
import compuwork.controller.*;
import compuwork.models.*;
import compuwork.service.Sistema;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final EmpleadoController empCtrl;
    private final DepartamentoController depCtrl;
    private final ReporteController repCtrl;
    private final AsignacionController asigCtrl;

    private String rol;

    public ConsoleView(Sistema sistema) {
        this.empCtrl = new EmpleadoController(sistema);
        this.depCtrl = new DepartamentoController(sistema);
        this.repCtrl = new ReporteController(sistema);
        this.asigCtrl = new AsignacionController(sistema);
    }

    public void iniciar() {
        seleccionarRol();

        int opcion;
        do {
            if (rol.equals("ADMIN")) {
                menuAdmin();
                opcion = leerInt("Opción: ");
                switch (opcion) {
                    case 1 -> registrarDepartamento();
                    case 2 -> registrarPermanente();
                    case 3 -> registrarTemporal();
                    case 4 -> depCtrl.listar();
                    case 5 -> empCtrl.listar();
                    case 6 -> asignar();
                    case 7 -> reporteEmpleado();
                    case 8 -> reporteDepartamento();
                    case 9 -> eliminarEmpleado();
                    case 10 -> eliminarDepartamento();
                    case 0 -> System.out.println("Bye!");
                    default -> System.out.println("Opción inválida");
                }
            } else { 
                menuEmpleado();
                opcion = leerInt("Opción: ");
                switch (opcion) {
                    case 1 -> reporteEmpleado();
                    case 2 -> reporteDepartamento();
                    case 0 -> System.out.println("Bye!");
                    default -> System.out.println("Opción inválida");
                }
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void seleccionarRol() {
        int opcion;
        do {
            System.out.println("Bienvenido a CompuWork");            
            System.out.println("----------------------");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1) rol = "ADMIN";
            else if (opcion == 2) rol = "EMPLEADO";
            else System.out.println("⚠ Opción inválida");
        } while (rol == null);
    }

    private void menuAdmin() {
        System.out.println("Menú Administrador");
        System.out.println("------------------");
        System.out.println("1. Registrar departamento");
        System.out.println("2. Registrar empleado PERMANENTE");
        System.out.println("3. Registrar empleado TEMPORAL");
        System.out.println("4. Listar departamentos");
        System.out.println("5. Listar empleados");
        System.out.println("6. Asignar empleado a departamento");
        System.out.println("7. Reporte individual");
        System.out.println("8. Reporte por departamento");
        System.out.println("9. Eliminar empleado");
        System.out.println("10. Eliminar departamento");
        System.out.println("0. Salir");
    }

    private void menuEmpleado() {
        System.out.println("===== Menú Empleado =====");
        System.out.println("1. Ver mi reporte individual");
        System.out.println("2. Ver reporte de mi departamento");
        System.out.println("0. Salir");
    }

    private int leerInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) { System.out.print("Ingrese entero: "); scanner.next(); }
        int v = scanner.nextInt(); scanner.nextLine(); return v;
    }
    
    private double leerDbl(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) { System.out.print("Ingrese número: "); scanner.next(); }
        double v = scanner.nextDouble(); scanner.nextLine(); return v;
    }
    
    private String leerTxt(String mensaje) { 
        System.out.print(mensaje); 
        return scanner.nextLine(); 
    }
    
    private LocalDate leerFecha(String mensaje) {
        while (true) {
            try { return LocalDate.parse(leerTxt(mensaje)); }
            catch (Exception e) { System.out.println("Formato: yyyy-MM-dd"); }
        }
    }

    private void registrarDepartamento() {
        String nombre = leerTxt("Ingrese el nombre del departamento: ");
        String descripcion = leerTxt("Ingrese la descripción del departamento: ");
        Departamento departamento = new Departamento(nombre, descripcion);
        depCtrl.registrar(departamento);
    }
    
    private void registrarPermanente() {
        String nombre = leerTxt("Ingrese el nombre: ");
        String apellido = leerTxt("Ingrese el apellido: ");
        int documento = leerInt("Ingrese el documento (número): ");
        LocalDate fechaIngreso = leerFecha("Ingrese la fecha de ingreso (yyyy-MM-dd): ");
        double salario = leerDbl("Ingrese el salario: ");
        LocalDate fechaVinculacion = leerFecha("Ingrese la fecha de vinculación (yyyy-MM-dd): ");
        String planBeneficios = leerTxt("Ingrese el plan de beneficios: ");

        Permanente permanente = new Permanente(nombre, apellido, documento, fechaIngreso, salario, fechaVinculacion, planBeneficios);
        empCtrl.registrar(permanente);

        System.out.println("Empleado permanente registrado con éxito.");
    }
    
    private void registrarTemporal() {
        String nombre = leerTxt("Ingrese el nombre: ");
        String apellido = leerTxt("Ingrese el apellido: ");
        int documento = leerInt("Ingrese el documento (número): ");
        LocalDate fechaIngreso = leerFecha("Ingrese la fecha de ingreso (yyyy-MM-dd): ");
        double salario = leerDbl("Ingrese el salario: ");
        LocalDate fechaVinculacion = leerFecha("Ingrese la fecha de vinculación (yyyy-MM-dd): ");
        LocalDate fechaCulminacion = leerFecha("Ingrese la fecha de culminación (yyyy-MM-dd): ");

        Temporal temporal = new Temporal(nombre, apellido, documento, fechaIngreso, salario, fechaVinculacion, fechaCulminacion);
        empCtrl.registrar(temporal);

        System.out.println("Empleado temporal registrado con éxito.");
    }
    
    private void asignar() {
        int idEmpleado = leerInt("Ingrese el ID del empleado: ");
        int idDepartamento = leerInt("Ingrese el ID del departamento: ");
        asigCtrl.asignar(idEmpleado, idDepartamento);
    }
    
    private void reporteEmpleado() {
        int id = leerInt("Ingrese el ID del empleado: ");
        repCtrl.empleado(id);
    }

    private void reporteDepartamento() {
        int id = leerInt("Ingrese el ID del departamento: ");
        repCtrl.departamento(id);
    }

    private void eliminarEmpleado() {
        int id = leerInt("Ingrese el ID del empleado a eliminar: ");
        empCtrl.eliminar(id);
    }

    private void eliminarDepartamento() {
        int id = leerInt("Ingrese el ID del departamento a eliminar: ");
        depCtrl.eliminar(id);
    }
}