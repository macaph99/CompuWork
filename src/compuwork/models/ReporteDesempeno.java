/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork.models;
 import java.time.LocalDate;
/**
 *
 * @author user
 */
public class ReporteDesempeno {
    private int idReporte;
    private LocalDate fechaGeneracion;
    private TipoReportes tipoReporte;
    private String metricas;
    
    public ReporteDesempeno(){
    
    }
    
    public ReporteDesempeno(int idReporte, LocalDate fechaGeneracion, TipoReportes tipoReporte, String metricas) {
        this.idReporte = idReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.tipoReporte = tipoReporte;
        this.metricas = metricas;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public TipoReportes getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReportes tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getMetricas() {
        return metricas;
    }

    public void setMetricas(String metricas) {
        this.metricas = metricas;
    }
    
    public void seleccionarTipoReporte(TipoReportes tipo) {
        this.tipoReporte = tipo;
    }

    public void generarReporte(){
        System.out.println("Generando reporte de tipo: " + tipoReporte);
    }
}

