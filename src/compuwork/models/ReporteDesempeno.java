package compuwork.models;

import java.time.LocalDate;

public class ReporteDesempeno {
    private static int contadorReporte = 1;
    private final int idReporte;
    private final LocalDate fechaGeneracion;
    private final TipoReportes tipoReporte;
    private String metricas;

    public ReporteDesempeno() {
        this(TipoReportes.INDIVIDUAL);
    }

    public ReporteDesempeno(TipoReportes tipo) {
        this.idReporte = contadorReporte++;
        this.tipoReporte = tipo;
        this.fechaGeneracion = LocalDate.now();
        this.metricas = "";
    }

    public int getIdReporte() {
        return idReporte;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public TipoReportes getTipoReporte() {
        return tipoReporte;
    }

    public String getMetricas() {
        return metricas;
    }

    public void setMetricas(String metricas) {
        this.metricas = metricas;
    }

    public static String generarReporteEmpleado(Empleado empleado) {
        return "Empleado: " + empleado.getNombre() + " " + empleado.getApellido() +
               " (id: " + empleado.getIdEmpleado() + ")\n" +
               "Tipo: " + empleado.getTipo_empleado() + "\n" +
               "Departamento: " + 
               (empleado.getDepartamento() == null ? "N/A" : empleado.getDepartamento().getNombre()) + "\n" +
               "Salario: " + String.format("%.2f", empleado.getSalario()) + "\n" +
               "Índice de desempeño: " + String.format("%.2f", empleado.calcularIndiceDesempeno());
    }

    public static String generarReporteDepartamento(Departamento departamento) {
        int numeroEmpleados = departamento.getEmpleados().size();
        double sumaSalarios = 0;
        double sumaIndiceDesempeno = 0;

        for (Empleado empleado : departamento.getEmpleados()) {
            sumaSalarios += empleado.getSalario();
            sumaIndiceDesempeno += empleado.calcularIndiceDesempeno();
        }

        double promSalarios = numeroEmpleados > 0 ? sumaSalarios / numeroEmpleados : 0;
        double promIndiceDesempeno = numeroEmpleados > 0 ? sumaIndiceDesempeno / numeroEmpleados : 0;

        return "Departamento: " + departamento.getNombre() + " (id=" + departamento.getIdDepartamento() + ")\n" +
               "Empleados: " + numeroEmpleados + "\n" +
               "Salario promedio: " + String.format("%.2f", promSalarios) + "\n" +
               "Índice promedio de desempeño: " + String.format("%.2f", promIndiceDesempeno);
    }

    public boolean mostrarReporte() {
        System.out.println();
        System.out.println("REPORTE (" + tipoReporte + ") #" + idReporte);
        System.out.println("Fecha: " + fechaGeneracion);
        System.out.println(metricas);
        System.out.println();
        return true;
    }

    @Override
    public String toString() {
        return "Reporte#" + idReporte + " (" + tipoReporte + ")";
    }
}
