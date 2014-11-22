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
public class ListadoPeriodoBean {
    
    @SerializedName("@periodos")
    private List<PeriodoBean> periodos;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public List<PeriodoBean> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<PeriodoBean> periodos) {
        this.periodos = periodos;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "ListadoPeriodoBean{" + "periodos=" + periodos + ", mensajeError=" + mensajeError + '}';
    }
    
    

    
}
