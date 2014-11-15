/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.colegio.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Alumnos
 */
public class NotaBean {
    @SerializedName("@alumnoId")
    private String alumnoId;    
    @SerializedName("@periodo")
    private String periodo;
    @SerializedName("@curso")
    private String curso;
    @SerializedName("@profesor")
    private String profesor;
    @SerializedName("@nota")
    private double nota;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
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
        return "NotaBean{" + "alumnoId=" + alumnoId + ", periodo=" + periodo + ", curso=" + curso + ", profesor=" + profesor + ", nota=" + nota + ", mensajeError=" + mensajeError + '}';
    }


}
