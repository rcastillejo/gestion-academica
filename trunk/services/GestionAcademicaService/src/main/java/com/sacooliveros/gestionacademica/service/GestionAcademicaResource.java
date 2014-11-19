/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.service;

import com.google.gson.Gson;
import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.LoginBean;
import com.sacooliveros.gestionacademica.message.MessageError;
import com.sacooliveros.gestionacademica.proxy.ColegioProxy;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.saco.webservices.WebServiceAlumno;
import pe.saco.webservices.WebServiceAlumno_Service;

/**
 * REST Web Service
 *
 * @author Alumnos
 */
@Path("GestionAcademica")
public class GestionAcademicaResource {

    private static final Logger log = LoggerFactory.getLogger(GestionAcademicaResource.class);

    private final WebServiceAlumno_Service alumnoService;
    private final ColegioProxy colegioProxy;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestionAcademicaResource
     */
    public GestionAcademicaResource() {
        colegioProxy = new ColegioProxy();
        alumnoService = new WebServiceAlumno_Service();
    }

    /**
     * Funcionalidads del Catalogo
     */
    /**
     * Validar Login
     *
     * @param username
     * @param password
     * @return
     */
    @GET
    @Path("/login/{username}/{password}")
    @Produces("application/json")
    public String login(@PathParam("username") String username, @PathParam("password") String password) {
        log.debug("login " + username + ", " + password + " ...");
        int r;
        String response;
        Gson gson = new Gson();

        LoginBean login = new LoginBean();

        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            r = port.validarAlumno(username, password);
            
            login.setSuccess(r == 1 ? Boolean.TRUE : Boolean.FALSE);
            
            log.debug("login obtenido " + r);
        } catch (Exception e) {
            log.error(MessageError.LOGIN + "[" + username + "]", e);
            login.setMensajeError(MessageError.LOGIN + "[" + username + "]");
        }
        response = gson.toJson(login);

        return response;
    }

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
        log.debug("Obteniendo alumno por " + id + " ...");
        AlumnoBean alumnoResponse;
        pe.saco.webservices.Alumno alumno;
        String response;
        Gson gson = new Gson();

        alumnoResponse = new AlumnoBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            alumno = port.consultarAlumno(id);

            alumnoResponse.setApellidoPaterno(alumno.getApellidopaterno());
            alumnoResponse.setApellidoMaterno(alumno.getApellidopaterno());
            alumnoResponse.setAula(alumno.getAula());
            alumnoResponse.setCentro(alumno.getCentro());
            alumnoResponse.setCorreo(alumno.getCorreo());
            alumnoResponse.setGrado(alumno.getGrado());
            alumnoResponse.setId(alumno.getUsuario());
            //alumnoResponse.setLocal(alumno.get());
            alumnoResponse.setNivel(alumno.getNivel());
            alumnoResponse.setNombres(alumno.getNombres());
            alumnoResponse.setSeccion(alumno.getSeccion());
            alumnoResponse.setTelefono(alumno.getTelefono());
            alumnoResponse.setTipoCentro(alumno.getTipoCentro());
            alumnoResponse.setTipoGrado(alumno.getTipoGrado());
            alumnoResponse.setTurno(alumno.getTurno());

        } catch (Exception e) {
            log.error(MessageError.GET_ALUMNO + "[" + id + "]", e);
            alumnoResponse.setMensajeError(MessageError.GET_ALUMNO + "[" + id + "]");
        }
        response = gson.toJson(alumnoResponse);
        log.debug("Alumno obtenido " + response);
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

        log.debug("alumno:\n" + response);
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
