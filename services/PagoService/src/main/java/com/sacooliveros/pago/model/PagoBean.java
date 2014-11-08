/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.pago.model;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author Alumnos
 */
public class PagoBean {
    @SerializedName("@usuario")
    public String usuario;
    @SerializedName("@password")
    public String password;
    @SerializedName("@codigo")
    public String codigo;
    @SerializedName("@nombre")
    public String nombre;
    @SerializedName("@anno")
    public String anno;
    
    
    @SerializedName("@itemno")
    public int itemno;
    @SerializedName("@mes")
    public String mes;
    @SerializedName("@concepto")
    public String concepto;
    @SerializedName("@estado")
    public String estado;
    @SerializedName("@monto")
    public double monto;
    @SerializedName("@fechavenc")
    public String fechavenc;
    @SerializedName("@fechapago")
    public String fechapago;
    @SerializedName("@mensajeerror")
    public String mensajeerror;
    
    
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    //datos de los comceptos a pagar
    public int getItemno(){
        return itemno;
    }
    public void setItemno(int itemno){
        this.itemno = itemno;
    }
    
    public String getMes(){
        return mes;
    }
    public void setMes(String mes){
        this.mes = mes;
    }
    
    public String getConcepto(){
        return nombre;
    }
    public void setConcepto(String concepto){
        this.concepto = concepto;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }

    public double getMonto(){
        return monto;
    }
    public void setMonto(double monto){
        this.monto = monto;
    }
    
    public String getFechavenc(){
        return fechavenc;
    }
    public void setFechavenc(String fechavenc){
        this.fechavenc = fechavenc;
    }
    
    public String getMensajeerror(){
        return mensajeerror;
    }
    public void setMensajeerror(String mensajeerror){
        this.mensajeerror = mensajeerror;
    }
    
    
}
