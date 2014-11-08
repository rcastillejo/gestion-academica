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
public class ColegioBean {
    @SerializedName("@usuario")
    public String usuario;
    @SerializedName("@password")
    public String password;
    
    
    @SerializedName("@nombre")
    public String nombre;
    
    @SerializedName("@tipocentro")
    public String tipocentro;
    
    @SerializedName("@nivel")
    public String nivel;
    
    @SerializedName("@tipogrado")
    public String tipogrado;
    
    @SerializedName("@sede")
    public String sede;
    
    public String mensajeerror;
    
    
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getTipocentro(){
        return tipocentro;
    }
    public void setTipocentro(String tipocentro){
        this.tipocentro = tipocentro;
    }
    
    public String getSede(){
        return sede;
    }
    public void setSede(String sede){
        this.sede = sede;
    }
    
    public String getTipogrado(){
        return tipogrado;
    }
    public void setTipogrado(String tipogrado){
        this.tipogrado = tipogrado;
    }
    
   
}
