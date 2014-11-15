/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.service;

import com.google.gson.Gson;
import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.AsistenciaBean;
import com.sacooliveros.gestionacademica.bean.DetalleAsistenciaBean;
import com.sacooliveros.gestionacademica.bean.NotaBean;
import com.sacooliveros.gestionacademica.bean.SimulacroBean;
import com.sacooliveros.gestionacademica.proxy.AbstractProxy;
import com.sacooliveros.gestionacademica.proxy.ColegioProxy;
import com.sacooliveros.gestionacademica.http.HttpControl;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Alumnos
 */
@Path("GestionAcademica")
public class GestionAcademicaResource {
    private final ColegioProxy colegioProxy;
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestionAcademicaResource
     */
    public GestionAcademicaResource() {
        colegioProxy = new ColegioProxy();
    }

    /**
     * Funcionalidads del Catalogo
     */
    /**
     * Consultar Datos
     *
     * @param id
     * @return
     */
    @GET
    @Path("/alumno/{id}")
    @Produces("application/json")
    public String getAlumno(@PathParam("id") String id) {
        System.out.println("Obteniendo alumno por " + id + " ...");
        String response;
        /*Gson gson = new Gson();
         AlumnoBean alumno = new AlumnoBean();
         alumno.setId(id);
         alumno.setNombres("Luis Ricardo");
         alumno.setApellidos("Castillejo Luna");
         alumno.setTelefono("12345678");
         alumno.setCorreo("rcastillejo@gmail.com");
         alumno.setAula("305");
         alumno.setNivel("01");
         return gson.toJson(alumno);*/ 
        
        response = colegioProxy.getAlumno(id);

        System.out.println("Alumno obtenido " + response);
        return response;
    }

    /**
     * Actualizar Datos
     *
     * @param content
     */
    @PUT
    @Path("/alumno")
    @Consumes("application/json")
    public void putAlumno(String content) {
        
        String response;
        /*Gson gson = new Gson();
        AlumnoBean alumno = gson.fromJson(content, AlumnoBean.class);*/
        
        response = colegioProxy.putAlumno(content);
        
        System.out.println("alumno:\n" + response);
    }

    /**
     * Consultar Notas
     *
     * @param alumnoId
     * @return
     */
    @GET
    @Path("/notas/{alumnoId}")
    @Produces("application/json")
    public String getNotas(@PathParam("alumnoId") String alumnoId) {
        String response;
        /*Gson gson = new Gson();

        List<NotaBean> notas = new ArrayList<NotaBean>();
        NotaBean nota = new NotaBean();
        nota.setAlumnoId(alumnoId);
        nota.setCurso("Matematicas");
        nota.setNota(15);
        nota.setPeriodo("1er Bimestre");
        nota.setProfesor("Ricarod Castillejo");

        notas.add(nota);*/

        response = colegioProxy.getNotas(alumnoId);
        return response;
    }

    /**
     * Consultar Resultado Simulacro
     *
     * @param alumnoId
     * @return
     */
    @GET
    @Path("/simulacro/{alumnoId}")
    @Produces("application/json")
    public String getSimulacro(@PathParam("alumnoId") String alumnoId) {
        String response;

        //Invocar al servicio ColegioService
        /*Gson gson = new Gson();
        SimulacroBean simulacro = new SimulacroBean();
        simulacro.setAlumnoId(alumnoId);
        simulacro.setCurso("Matematicas");
        simulacro.setNota(15);
        simulacro.setPeriodo("1er Bimestre");

        return gson.toJson(simulacro);*/
        response = colegioProxy.getNotas(alumnoId);
        return response;
    }

    /**
     * Consultar Asistencia
     *
     * @param alumnoId
     * @return
     */
    @GET
    @Path("/asistencia/{alumnoId}")
    @Produces("application/json")
    public String getAsistencia(@PathParam("alumnoId") String alumnoId) {

        String response;
        /*Gson gson = new Gson();

        DetalleAsistenciaBean dia = new DetalleAsistenciaBean();
        dia.setAnio(2012);
        dia.setDia(12);
        dia.setMes(12);
        dia.setEstado("TAR");

        List dias = new ArrayList<DetalleAsistenciaBean>();
        dias.add(dia);

        AsistenciaBean asistencia = new AsistenciaBean();
        asistencia.setAlumnoId(alumnoId);
        asistencia.setFechaIni("12/12/12");
        asistencia.setFechaFin("12/12/12");
        asistencia.setTotalAsi(10);
        asistencia.setTotalIna(10);
        asistencia.setTotalJus(0);
        asistencia.setTotalNom(0);
        asistencia.setTotalTar(0);
        asistencia.setDetalleAsistencia(dias);

        return gson.toJson(asistencia);*/
        response = colegioProxy.getAsistencia(alumnoId);
        return response;
    }
}
