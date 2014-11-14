/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.pago.pagoservice;

import com.google.gson.Gson;
import com.sacooliveros.pago.model.PagoBean;
import java.util.ArrayList;
import java.util.List;
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
    public String ConsultarPensiones(@PathParam("alumnoId") String alumnoId) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Gson vgson = new Gson();
        List<PagoBean> pagos = new ArrayList<PagoBean>();
        PagoBean pago = new PagoBean();
        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 1;
        pago.mes = "MARZO";
        pago.concepto="MATRICULA";
        pago.estado ="CANCELADO";
        pago.monto = 200;
        pago.fechavenc="01/03/2014";
        pago.fechapago="22/02/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);
        
        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 2;
        pago.mes = "MARZO";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/03/2014";
        pago.fechapago="30/02/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 3;
        pago.mes = "ABRIL";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/04/2014";
        pago.fechapago="30/03/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 4;
        pago.mes = "MAYO";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/05/2014";
        pago.fechapago="30/04/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 5;
        pago.mes = "JUNIO";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/06/2014";
        pago.fechapago="30/05/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 6;
        pago.mes = "JULIO";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 170;
        pago.fechavenc="07/07/2014";
        pago.fechapago="30/06/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 7;
        pago.mes = "AGOSTO";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/08/2014";
        pago.fechapago="30/07/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 8;
        pago.mes = "SETIEMBRE";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/09/2014";
        pago.fechapago="30/08/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 9;
        pago.mes = "OCTUBRE";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/10/2014";
        pago.fechapago="30/09/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 10;
        pago.mes = "MOVIEMBRE";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 150;
        pago.fechavenc="07/11/2014";
        pago.fechapago="30/10/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        pago.anno = "2014";
        pago.codigo="JPEREZ";
        pago.itemno = 11;
        pago.mes = "DICIEMBRE";
        pago.concepto="PENSION";
        pago.estado ="CANCELADO";
        pago.monto = 170;
        pago.fechavenc="07/12/2014";
        pago.fechapago="30/11/2014";
        pago.nombre = "JUAN PEREZ";
        pagos.add(pago);

        return vgson.toJson(pagos);
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
