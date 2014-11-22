/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gestionacademica.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class PeriodoBean {
    @SerializedName("@id")
    private int id;
    @SerializedName("@nombre")
    private String nombre;
    @SerializedName("@notas")
    private List<NotaBean> notas;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public PeriodoBean(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PeriodoBean() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<NotaBean> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaBean> notas) {
        this.notas = notas;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "PeriodoBean{" + "id=" + id + ", nombre=" + nombre + ", notas=" + notas + ", mensajeError=" + mensajeError + '}';
    }
    
}
