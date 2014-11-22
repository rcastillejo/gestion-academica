/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.bean;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Alumnos
 */
public class DetalleAsistenciaBean {

    @SerializedName("@dia")
    private String dia;
    @SerializedName("@mes")
    private String mes;
    @SerializedName("@anio")
    private String anio;
    @SerializedName("@estado")
    private String estado;
    @SerializedName("@mensajeError")
    private String mensajeError;

    public DetalleAsistenciaBean(String dia, String mes, String estado) {
        this.dia = dia;
        this.mes = mes;
        this.estado = estado;
    }

    public DetalleAsistenciaBean() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "DetalleAsistenciaBean{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", estado=" + estado + ", mensajeError=" + mensajeError + '}';
    }
    
}
