/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compuwork;

//import compuwork.models.ReporteDesempeno;
//import compuwork.models.TipoReportes;
import compuwork.views.consoleView;

    public class CompuWork {
    public static void main(String[] args) {
        //aca toca largo paor el error en sintaxis
        compuwork.views.consoleView view = new compuwork.views.consoleView();
        view.mostrarMenu();  // aquí arrancamos el menú
    }
    
    //public static void main(String[] args) {
       // ReporteDesempeno type = new ReporteDesempeno();        

        //type.seleccionarTipoReporte(TipoReportes.DEPARTAMENTO);
       // type.generarReporte();
       // System.out.println("El tipo de reporte es: " + type.getTipoReporte());
}   

