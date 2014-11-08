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
public class AlumnoBean {
    @SerializedName("@id")
    private String id;
    @SerializedName("@nombres")
    private String nombres;
    @SerializedName("@apellidos")
    private String apellidos;
    @SerializedName("@telefono")
    private String telefono;
    @SerializedName("@correo")
    private String correo;
    
    
    @SerializedName("@local")
    private String local;
    @SerializedName("@tipoCentro")
    private String tipoCentro;
    @SerializedName("@centro")
    private String centro;
    @SerializedName("@tipoGrado")
    private String tipoGrado;
    @SerializedName("@grado")
    private String grado;
    @SerializedName("@seccion")
    private String turno;
    
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String loca) {
        this.local = loca;
    }

    public String getTipoCentro() {
        return tipoCentro;
    }

    public void setTipoCentro(String tipoCentro) {
        this.tipoCentro = tipoCentro;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getTipoGrado() {
        return tipoGrado;
    }

    public void setTipoGrado(String tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "AlumnoBean{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo=" + correo + ", loca=" + local + ", tipoCentro=" + tipoCentro + ", centro=" + centro + ", tipoGrado=" + tipoGrado + ", grado=" + grado + ", turno=" + turno + ", mensajeError=" + mensajeError + '}';
    }


    
}
