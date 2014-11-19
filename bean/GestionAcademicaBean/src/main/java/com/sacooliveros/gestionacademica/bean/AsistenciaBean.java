/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Alumnos
 */
public class AsistenciaBean {

    @SerializedName("@alumnoId")
    private String alumnoId;
    @SerializedName("@fechaIni")
    private String fechaIni;
    @SerializedName("@fechaFin")
    private String fechaFin;
    @SerializedName("@detalleAsistencia")
    private List<DetalleAsistenciaBean> detalleAsistencia;
    @SerializedName("@totalAsi")
    private int totalAsi;
    @SerializedName("@totalTar")
    private int totalTar;
    @SerializedName("@totalIna")
    private int totalIna;
    @SerializedName("@totalJus")
    private int totalJus;
    @SerializedName("@totalPer")
    private int totalPer;
    @SerializedName("@totalNom")
    private int totalNom;
    @SerializedName("@mensajeError")
    private String mensajeError;

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<DetalleAsistenciaBean> getDetalleAsistencia() {
        return detalleAsistencia;
    }

    public void setDetalleAsistencia(List<DetalleAsistenciaBean> detalleAsistencia) {
        this.detalleAsistencia = detalleAsistencia;
    }

    public int getTotalAsi() {
        return totalAsi;
    }

    public void setTotalAsi(int totalAsi) {
        this.totalAsi = totalAsi;
    }

    public int getTotalTar() {
        return totalTar;
    }

    public void setTotalTar(int totalTar) {
        this.totalTar = totalTar;
    }

    public int getTotalIna() {
        return totalIna;
    }

    public void setTotalIna(int totalIna) {
        this.totalIna = totalIna;
    }

    public int getTotalJus() {
        return totalJus;
    }

    public void setTotalJus(int totalJus) {
        this.totalJus = totalJus;
    }

    public int getTotalPer() {
        return totalPer;
    }

    public void setTotalPer(int totalPer) {
        this.totalPer = totalPer;
    }

    public int getTotalNom() {
        return totalNom;
    }

    public void setTotalNom(int totalNom) {
        this.totalNom = totalNom;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "AssitenciaBean{" + "alumnoId=" + alumnoId + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", detalleAsistencia=" + detalleAsistencia + ", totalAsi=" + totalAsi + ", totalTar=" + totalTar + ", totalIna=" + totalIna + ", totalJus=" + totalJus + ", totalPer=" + totalPer + ", totalNom=" + totalNom + ", mensajeError=" + mensajeError + '}';
    } 
}
