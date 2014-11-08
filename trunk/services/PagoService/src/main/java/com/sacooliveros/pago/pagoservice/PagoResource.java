/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.pago.pagoservice;

import com.google.gson.Gson;
import com.sacooliveros.pago.model.PagoBean;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Alumnos
 */
@Path("Pago")
public class PagoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PagoResource
     */
    public PagoResource() {
    }

    /**
     * Retrieves representation of an instance of com.sacooliveros.pago.pagoservice.PagoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{alumnoId}")
    @Produces("application/json")
    public String getJson(@PathParam("alumnoId") String alumnoId) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Gson vgson = new Gson();
        PagoBean pago = new PagoBean();
        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 1;
        pago.mes = "MARZO";
        pago.concepto="MATRICULA";
        pago.estado ="CANCELADO";
        pago.monto = 200;
        pago.fechavenc="15/03/2014";
        pago.fechapago="05/03/2014";
        pago.nombre = "JUAN PEREZ";
        
        
        return vgson.toJson(pago);
    }

    /**
     * PUT method for updating or creating an instance of PagoResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
