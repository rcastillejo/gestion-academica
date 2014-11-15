/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.proxy;

import com.sacooliveros.gestionacademica.http.HttpControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public abstract class AbstractProxy {
    private static final Logger log = LoggerFactory.getLogger(AbstractProxy.class);
    private final String serviceUrl;

    public AbstractProxy(String url, String service) {
        this.serviceUrl = url + service;
    }

    public String getServiceUrl() {
        return this.serviceUrl;
    }

    public String get(String path, String params) {
        String response = HttpControl.getJson(this.serviceUrl + path +  params);
        return response;
    }

    public String put(String path, String content) {
        String response = HttpControl.putJson(this.serviceUrl + path, content);
        return response;
    }
}
