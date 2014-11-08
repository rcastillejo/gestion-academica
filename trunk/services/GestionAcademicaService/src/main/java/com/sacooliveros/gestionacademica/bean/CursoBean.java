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
public class CursoBean {
    @SerializedName("@nombre")
    private String nombre;    
    @SerializedName("@nota")
    private String nota;
    @SerializedName("@periodo")
    private String periodo;
    
        
    @SerializedName("@mensajeError")
    private String mensajeError;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "CursoBean{" + "nombre=" + nombre + ", nota=" + nota + ", periodo=" + periodo + ", mensajeError=" + mensajeError + '}';
    }

    
    
}
