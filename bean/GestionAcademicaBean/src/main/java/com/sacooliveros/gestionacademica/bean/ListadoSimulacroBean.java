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
public class ListadoSimulacroBean {
    
    @SerializedName("@simulacros")
    private List<SimulacroBean> simulacros;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public List<SimulacroBean> getSimulacros() {
        return simulacros;
    }

    public void setSimulacros(List<SimulacroBean> simulacros) {
        this.simulacros = simulacros;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    
}
