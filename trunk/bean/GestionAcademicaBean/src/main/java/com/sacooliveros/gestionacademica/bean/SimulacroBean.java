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
public class SimulacroBean {
    @SerializedName("@alumnoId")
    private String alumnoId;    
    @SerializedName("@simulacroId")
    private String simulacroId;
    @SerializedName("@nombre")
    private String nombre;
    @SerializedName("@nota")
    private double nota;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public SimulacroBean(String alumnoId, String simulacroId, String nombre, double nota) {
        this.alumnoId = alumnoId;
        this.simulacroId = simulacroId;
        this.nombre = nombre;
        this.nota = nota;
    }

    public SimulacroBean() {
    }

    public String getSimulacroId() {
        return simulacroId;
    }

    public void setSimulacroId(String simulacroId) {
        this.simulacroId = simulacroId;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "SimulacroBean{" + "alumnoId=" + alumnoId + ", simulacroId=" + simulacroId + ", nombre=" + nombre + ", nota=" + nota + ", mensajeError=" + mensajeError + '}';
    }


}
