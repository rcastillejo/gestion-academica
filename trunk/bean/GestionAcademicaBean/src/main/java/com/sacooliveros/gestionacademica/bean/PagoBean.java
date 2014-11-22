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
public class PagoBean {
    @SerializedName("@alumnoId")
    private String alumnoId;
    @SerializedName("@nombrePago")
    private String nombrePago;
    @SerializedName("@monto")
    private String monto;
    @SerializedName("@aCuenta")
    private String aCuenta;
    @SerializedName("@aPagar")
    private String aPagar;
    @SerializedName("@descuento")
    private String descuento;
    @SerializedName("@fechaPago")
    private String fechaPago;
    @SerializedName("@fechaVcto")
    private String fechaVcto;
    @SerializedName("@mora")
    private String mora;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public PagoBean(String alumnoId, String nombrePago, String monto, String aCuenta, String aPagar, String descuento, String fechaPago, String fechaVcto, String mora) {
        this.alumnoId = alumnoId;
        this.nombrePago = nombrePago;
        this.monto = monto;
        this.aCuenta = aCuenta;
        this.aPagar = aPagar;
        this.descuento = descuento;
        this.fechaPago = fechaPago;
        this.fechaVcto = fechaVcto;
        this.mora = mora;
    }

    public PagoBean() {
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getaCuenta() {
        return aCuenta;
    }

    public void setaCuenta(String aCuenta) {
        this.aCuenta = aCuenta;
    }

    public String getaPagar() {
        return aPagar;
    }

    public void setaPagar(String aPagar) {
        this.aPagar = aPagar;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFechaVcto() {
        return fechaVcto;
    }

    public void setFechaVcto(String fechaVcto) {
        this.fechaVcto = fechaVcto;
    }

    public String getMora() {
        return mora;
    }

    public void setMora(String mora) {
        this.mora = mora;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

     

    @Override
    public String toString() {
        return "PagoBean{" + "alumnoId=" + alumnoId + ", nombrePago=" + nombrePago + ", monto=" + monto + ", aCuenta=" + aCuenta + ", aPagar=" + aPagar + ", descuento=" + descuento + ", fechaPago=" + fechaPago + ", fechaVcto=" + fechaVcto + ", mora=" + mora + ", mensajeError=" + mensajeError + '}';
    }
    
    
}
