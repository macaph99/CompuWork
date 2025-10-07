package compuwork.controller;

import compuwork.models.ReporteDesempeno;
import compuwork.service.Sistema;

public class ReporteController {
    private final Sistema sistema;

    public ReporteController(Sistema sistema) {
        this.sistema = sistema;
    }

    public String empleadoTexto(int idEmpleado) throws Exception {
        ReporteDesempeno reporte = sistema.reporteEmpleado(idEmpleado);
        return "REPORTE INDIVIDUAL\n\n" + reporte.getMetricas();
    }

    public String departamentoTexto(int idDepartamento) throws Exception {
        ReporteDesempeno reporte = sistema.reporteDepartamento(idDepartamento);
        return "REPORTE POR DEPARTAMENTO\n\n" + reporte.getMetricas();
    }
}
