/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.service;

import com.google.gson.Gson;
import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.AsistenciaBean;
import com.sacooliveros.gestionacademica.bean.DetalleAsistenciaBean;
import com.sacooliveros.gestionacademica.bean.ListadoPagoBean;
import com.sacooliveros.gestionacademica.bean.ListadoPeriodoBean;
import com.sacooliveros.gestionacademica.bean.ListadoSimulacroBean;
import com.sacooliveros.gestionacademica.bean.LoginBean;
import com.sacooliveros.gestionacademica.bean.NotaBean;
import com.sacooliveros.gestionacademica.bean.PagoBean;
import com.sacooliveros.gestionacademica.bean.PeriodoBean;
import com.sacooliveros.gestionacademica.bean.SimulacroBean;
import com.sacooliveros.gestionacademica.message.MessageError;
import com.sacooliveros.gestionacademica.proxy.ColegioProxy;
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
        int codigoUsuario;
        String response;
        Gson gson = new Gson();

        LoginBean login = new LoginBean();

        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            codigoUsuario = port.validarAlumno(username, password);
            login.setCodigoAlumno(codigoUsuario + "");

            login.setSuccess(codigoUsuario != 0);
            
            if(!login.isSuccess()){
                login.setMensajeError(MessageError.LOGIN_ERROR);
            }
            log.debug("login obtenido " + codigoUsuario);
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
    @Path("/periodos/{alumnoId}")
    @Produces("application/json")
    public String getPeriodos(@PathParam("alumnoId") String alumnoId) {
        String response;
        List<PeriodoBean> periodoList;
        ListadoPeriodoBean listadoPeriodoResponse;
        List<pe.saco.webservices.Periodo> periodos;
        Gson gson = new Gson();

        listadoPeriodoResponse = new ListadoPeriodoBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            periodos = port.consultarPeriodo(alumnoId);

            periodoList = new ArrayList<PeriodoBean>();
            for (pe.saco.webservices.Periodo periodo : periodos) {
                periodoList.add(new PeriodoBean(periodo.getCodigoPeriodo(), periodo.getNombrePeriodo()));
            }

            listadoPeriodoResponse.setPeriodos(periodoList);
        } catch (Exception e) {
            log.error(MessageError.GET_PERIODOS + "[" + alumnoId + "]", e);
            listadoPeriodoResponse.setMensajeError(MessageError.GET_PERIODOS + "[" + alumnoId + "]");
        }
        response = gson.toJson(listadoPeriodoResponse);
        log.debug("Periodos obtenido " + response);
        return response;
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
        List<PeriodoBean> periodosResponse;
        ListadoPeriodoBean listadoPeriodoResponse;
        List<pe.saco.webservices.Periodo> periodos;

        Gson gson = new Gson();

        listadoPeriodoResponse = new ListadoPeriodoBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            periodos = port.consultarPeriodo(alumnoId);

            periodosResponse = new ArrayList<PeriodoBean>();
            for (pe.saco.webservices.Periodo periodo : periodos) {
                PeriodoBean periodoResponse = new PeriodoBean(periodo.getCodigoPeriodo(), periodo.getNombrePeriodo());
                List<NotaBean> notasResponse = new ArrayList<NotaBean>();

                List<pe.saco.webservices.Nota> notas = port.consultarNota(alumnoId, periodo.getCodigoPeriodo() + "");
                for (pe.saco.webservices.Nota nota : notas) {
                    notasResponse.add(new NotaBean(nota.getNombreCurso(), nota.getNota()));
                }

                periodoResponse.setNotas(notasResponse);
                periodosResponse.add(periodoResponse);
            }

            listadoPeriodoResponse.setPeriodos(periodosResponse);
        } catch (Exception e) {
            log.error(MessageError.GET_NOTAS + "[" + alumnoId + "]", e);
            listadoPeriodoResponse.setMensajeError(MessageError.GET_NOTAS + "[" + alumnoId + "]");
        }
        response = gson.toJson(listadoPeriodoResponse);
        log.debug("Notas obtenido " + response);
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

        List<pe.saco.webservices.Simulacro> simulacros;
        List<SimulacroBean> simulacrosResponse;
        ListadoSimulacroBean listadoSimulacroResponse;
        double resultadoSimulacro;
        Gson gson = new Gson();

        listadoSimulacroResponse = new ListadoSimulacroBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            simulacros = port.consultarSimulacro(alumnoId);

            simulacrosResponse = new ArrayList<SimulacroBean>();
            for (pe.saco.webservices.Simulacro simulacro : simulacros) {
                resultadoSimulacro = port.consultarResultadoSimulacro(alumnoId, simulacro.getCodigoSimulacro() + "");
                simulacrosResponse.add(new SimulacroBean(alumnoId, simulacro.getCodigoSimulacro() + "", 
                        simulacro.getNombreSimulacro(), resultadoSimulacro));
            }

            listadoSimulacroResponse.setSimulacros(simulacrosResponse);
        } catch (Exception e) {
            log.error(MessageError.GET_SIMULACRO + "[" + alumnoId + "]", e);
            listadoSimulacroResponse.setMensajeError(MessageError.GET_SIMULACRO + "[" + alumnoId + "]");
        }
        response = gson.toJson(listadoSimulacroResponse);
        log.debug("Simulacro obtenido " + response);
        return response;
    }

    public String getSimulacroMock(String alumnoId) {
        String response;
        ListadoSimulacroBean listadoSimulacroResponse = new ListadoSimulacroBean();
        List<SimulacroBean> simulacrosResponse;
        Gson gson = new Gson();
        try {
            simulacrosResponse = new ArrayList<SimulacroBean>();
            simulacrosResponse.add(new SimulacroBean(alumnoId, "1", "Simulacro A", 15D));
            simulacrosResponse.add(new SimulacroBean(alumnoId, "2", "Simulacro B", 14D));
            simulacrosResponse.add(new SimulacroBean(alumnoId, "3", "Simulacro C", 15D));
            simulacrosResponse.add(new SimulacroBean(alumnoId, "4", "Simulacro D", 18D));
            simulacrosResponse.add(new SimulacroBean(alumnoId, "5", "Simulacro E", 19D));
            listadoSimulacroResponse.setSimulacros(simulacrosResponse);
        } catch (Exception e) {
            log.error(MessageError.GET_SIMULACRO + "[" + alumnoId + "]", e);
            listadoSimulacroResponse.setMensajeError(MessageError.GET_SIMULACRO + "[" + alumnoId + "]");
        }
        response = gson.toJson(listadoSimulacroResponse);
        log.debug("Simulacro obtenido " + response);
        return response;
    }

    /**
     * Consultar Asistencia
     *
     * @param alumnoId
     * @param mes
     * @return
     */
    @GET
    @Path("/asistencia/{alumnoId}/{mes}")
    @Produces("application/json")
    public String getAsistencia(@PathParam("alumnoId") String alumnoId, @PathParam("mes") String mes) {

        String response;
        Gson gson = new Gson();
        List<pe.saco.webservices.Asistencia> detalleAsistencia;
        pe.saco.webservices.AsistenciaTotales totales;
        List<DetalleAsistenciaBean> detalleAsistenciaResponse;
        AsistenciaBean asistenciaResponse;

        asistenciaResponse = new AsistenciaBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            totales = port.consultarAsistenciaTotales(alumnoId, mes);

            asistenciaResponse.setAlumnoId(alumnoId);
            asistenciaResponse.setMes(mes);
            asistenciaResponse.setTotalAsi(totales.getAsi());
            asistenciaResponse.setTotalIna(totales.getIna());
            asistenciaResponse.setTotalJus(totales.getJus());
            asistenciaResponse.setTotalNom(totales.getNom());
            asistenciaResponse.setTotalPer(totales.getPer());
            asistenciaResponse.setTotalTar(totales.getTar());

            detalleAsistencia = port.consultarAsistencia(alumnoId, mes);

            detalleAsistenciaResponse = new ArrayList<DetalleAsistenciaBean>();
            for (pe.saco.webservices.Asistencia asistencia : detalleAsistencia) {
                log.trace("detalle asistencia [dia={}, mes={}, tipo={}]", new Object[]{asistencia.getDia(), mes, asistencia.getTipoAsistencia()});
                detalleAsistenciaResponse.add(new DetalleAsistenciaBean(asistencia.getDia(), mes, asistencia.getTipoAsistencia()));
            }

            asistenciaResponse.setDetalleAsistencia(detalleAsistenciaResponse);
        } catch (Exception e) {
            log.error(MessageError.GET_ASISTENCIA + "[" + alumnoId + "]", e);
            asistenciaResponse.setMensajeError(MessageError.GET_ASISTENCIA + "[" + alumnoId + "]");
        }
        response = gson.toJson(asistenciaResponse);
        log.debug("Asistencia obtenido " + response);
        return response;
    }

    /**
     * Consultar Pago
     *
     * @param alumnoId
     * @return
     */
    @GET
    @Path("/pago/{alumnoId}")
    @Produces("application/json")
    public String getPago(@PathParam("alumnoId") String alumnoId) {

        String response;
        Gson gson = new Gson();
        List<pe.saco.webservices.Pago> pagos;
        List<PagoBean> pagosResponse;
        ListadoPagoBean listadoPagoResponse;

        listadoPagoResponse = new ListadoPagoBean();
        try {
            WebServiceAlumno port = alumnoService.getWebServiceAlumnoPort();
            pagos = port.consultarPago(alumnoId);

            pagosResponse = new ArrayList<PagoBean>();
            for (pe.saco.webservices.Pago pago : pagos) {
                pagosResponse.add(new PagoBean(alumnoId, pago.getNombrePago(),
                        pago.getMonto(), pago.getACta(), pago.getAPagar(), pago.getDcto(),
                        pago.getFechaP(), pago.getFechaV(), pago.getMora()));
            }

            listadoPagoResponse.setPagos(pagosResponse);
        } catch (Exception e) {
            log.error(MessageError.GET_PAGO + "[" + alumnoId + "]", e);
            listadoPagoResponse.setMensajeError(MessageError.GET_PAGO + "[" + alumnoId + "]");
        }
        response = gson.toJson(listadoPagoResponse);
        log.debug("Pagos obtenido " + response);
        return response;
    }
}
