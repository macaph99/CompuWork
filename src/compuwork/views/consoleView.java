/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.views;

import java.util.Scanner;
//import compuwork.models.Empleado;
//import compuwork.models.Permanente;
//import java.time.LocalDate;

public class consoleView {
     private Scanner sc = new Scanner(System.in);

     
 public void mostrarMenu() {
        int opcion; // aquí se guarda la opción que elija el usuario
        
        //do while
        do {
            // Mostramos el menú principal
            System.out.println("=== Bienvenido a CompuWork ===");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            
            opcion = sc.nextInt(); // leemos la opción ingresada

            // Revisamos la opción
            switch (opcion) {
                case 1:
                    mostrarSubmenuAdministrador();
                    break;
                case 2:
                    mostrarSubmenuEmpleado();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema... ¡Gracias por usar Compuwork!");
                    break;
                default:
                    System.out.println("⚠️ Opcion inválida, intente de nuevo.");
            }
        } while (opcion != 0); // se repite mientras no elija 0
    }

    // Submenú administrador
    private void mostrarSubmenuAdministrador() {
        System.out.println("\n--- Menu Administrador ---");
        System.out.println("1. Ver departamentos");
        System.out.println("2. Agregar empleado");
        System.out.println("3. Generar reporte");
        System.out.println("0. Volver al menu principal");
        // Aquí podrías leer otra opción y hacer otro switch
    }

    // Submenú empleado
    private void mostrarSubmenuEmpleado() {
        System.out.println("\n--- Menu Empleado ---");
        System.out.println("Ingrese los datos del empleado...");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Apellido: ");
        String apellido = sc.next();
        // etc...
        System.out.println("Empleado registrado: " + id + " - " + nombre + " " + apellido);
    }
}
