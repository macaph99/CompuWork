/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compuwork;
import compuwork.service.Sistema;
import compuwork.view.ConsoleView;

public class compuwork {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        new ConsoleView(sistema).iniciar();
    }
}