/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.http;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class HttpControl {
    
    private static final Logger log = LoggerFactory.getLogger(HttpGetter.class);
    
    public static String putJson(String url, String json) {
        HttpPostter poster = new HttpPostter();
        poster.setUrl(url);
        
        log.trace("Asignado URL:{}", url);
        
        poster.setRequest(json);
        try {
            poster.invoke();
        } catch (ClientProtocolException e) {
            log.error("Error!", e);
        } catch (IOException e) {
            log.error("Error!", e);
        } catch (Exception e) {
            log.error("Error!", e);
        }
        return poster.getResponse();
    }
    
    public static String getJson(String url) {
        HttpGetter poster = new HttpGetter();
        
        log.trace("Asignado URL:{}", url);
        
        poster.setUrl(url);

        //poster.setRequest(json);
        try {
            poster.invoke();
        } catch (ClientProtocolException e) {
            log.error("Error!", e);
        } catch (IOException e) {
            log.error("Error!", e);
        } catch (Exception e) {
            log.error("Error!", e);
        }
        return poster.getResponse();
    }
    
}
