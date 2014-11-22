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
public class NotaBean {
    @SerializedName("@alumnoId")
    private String alumnoId;
    @SerializedName("@curso")
    private String curso;
    @SerializedName("@nota")
    private String nota;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
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
        return "NotaBean{" + "alumnoId=" + alumnoId + ", curso=" + curso + ", nota=" + nota + ", mensajeError=" + mensajeError + '}';
    }


}
