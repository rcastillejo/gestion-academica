package com.sacooliveros.intranet.bean;

public class AlumnoBean {
    private String id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;   
    
    private String local;
    private String tipoCentro;
    private String centro;
    private String tipoGrado;
    private String grado;
    
    private String turno;
    
    
    
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

    public void setLocal(String local) {
        this.local = local;
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
        return "AlumnoBean{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo=" + correo + ", local=" + local + ", tipoCentro=" + tipoCentro + ", centro=" + centro + ", tipoGrado=" + tipoGrado + ", grado=" + grado + ", turno=" + turno + ", mensajeError=" + mensajeError + '}';
    }


    
}