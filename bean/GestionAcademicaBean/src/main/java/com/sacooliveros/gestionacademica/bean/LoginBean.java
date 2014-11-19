/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gestionacademica.bean;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Ricardo
 */
public class LoginBean {
    @SerializedName("@success")
    boolean success;
    
    @SerializedName("@mensajeError")
    private String mensajeError;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "LoginBean{" + "success=" + success + ", mensajeError=" + mensajeError + '}';
    }
    
    
}
