/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compuwork;
import compuwork.controller.DepartamentoController;
import compuwork.service.Sistema;
import compuwork.view.ConsoleView;
import compuwork.view.DepartamentoView;
import compuwork.view.SeleccionDeRol;

public class CompuWork {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        //new ConsoleView(sistema).iniciar();

        //DepartamentoController depCtrl = new DepartamentoController(sistema);
        SeleccionDeRol view = new SeleccionDeRol();
        //DepartamentoView view = new DepartamentoView(depCtrl);
        view.setVisible(true);
    }
}