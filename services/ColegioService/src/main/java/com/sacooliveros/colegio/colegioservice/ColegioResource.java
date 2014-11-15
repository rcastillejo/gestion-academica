/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.colegio.colegioservice;

import com.google.gson.Gson;
import com.sacooliveros.colegio.model.AlumnoBean;
import com.sacooliveros.colegio.model.AsistenciaBean;
import com.sacooliveros.colegio.model.DetalleAsistenciaBean;
import com.sacooliveros.colegio.model.NotaBean;
import com.sacooliveros.colegio.model.SimulacroBean;
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
 * @author proyecto
 */
@Path("Colegio")
public class ColegioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ColegioResource
     */
    public ColegioResource() {
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
        Gson gson = new Gson();
        AlumnoBean alumno = new AlumnoBean();
        alumno.setId(id);
        alumno.setNombres("Luis Ricardo");
        alumno.setApellidos("Castillejo Luna");
        alumno.setTelefono("12345678");
        alumno.setCorreo("rcastillejo@gmail.com");
        alumno.setAula("305");
        alumno.setNivel("01");
        System.out.println("Alumno obtenido " + alumno);
        return gson.toJson(alumno);
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
        Gson gson = new Gson();
        AlumnoBean alumno = gson.fromJson(content, AlumnoBean.class);
        System.out.println("alumno:\n" + alumno);
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
        Gson gson = new Gson();

        List<NotaBean> notas = new ArrayList<NotaBean>();
        NotaBean nota = new NotaBean();
        nota.setAlumnoId(alumnoId);
        nota.setCurso("Matematicas");
        nota.setNota(15);
        nota.setPeriodo("1er Bimestre");
        nota.setProfesor("Ricarod Castillejo");

        notas.add(nota);

        return gson.toJson(notas);
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

        //Invocar al servicio ColegioService
        Gson gson = new Gson();
        SimulacroBean simulacro = new SimulacroBean();
        simulacro.setAlumnoId(alumnoId);
        simulacro.setCurso("Matematicas");
        simulacro.setNota(15);
        simulacro.setPeriodo("1er Bimestre");

        return gson.toJson(simulacro);
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

        Gson gson = new Gson();

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

        return gson.toJson(asistencia);
    }
}
