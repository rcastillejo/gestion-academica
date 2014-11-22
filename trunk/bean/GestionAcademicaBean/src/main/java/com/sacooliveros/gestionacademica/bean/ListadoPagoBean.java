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
public class ListadoPagoBean {
    
    @SerializedName("@pagos")
    private List<PagoBean> pagos;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public List<PagoBean> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoBean> pagos) {
        this.pagos = pagos;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "ListadoPagoBean{" + "pagos=" + pagos + ", mensajeError=" + mensajeError + '}';
    }

    
    
}
