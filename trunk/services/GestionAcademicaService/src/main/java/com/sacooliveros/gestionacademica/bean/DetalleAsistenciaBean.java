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
    private int dia;
    @SerializedName("@mes")
    private int mes;
    @SerializedName("@anio")
    private int anio;
    @SerializedName("@estado")
    private String estado;
    @SerializedName("@mensajeError")
    private String mensajeError;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
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
        return "AsistenciaDiaBean{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", estado=" + estado + ", mensajeError=" + mensajeError + '}';
    }
}
