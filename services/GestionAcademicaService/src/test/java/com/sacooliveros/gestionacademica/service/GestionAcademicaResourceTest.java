/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.service;

import com.google.gson.Gson;
import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.AsistenciaBean;
import com.sacooliveros.gestionacademica.bean.ListadoPagoBean;
import com.sacooliveros.gestionacademica.bean.ListadoPeriodoBean;
import com.sacooliveros.gestionacademica.bean.ListadoSimulacroBean;
import com.sacooliveros.gestionacademica.bean.LoginBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class GestionAcademicaResourceTest {

    public GestionAcademicaResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "151300763";
        String password = "151400829a19";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        LoginBean expResult;
        
        expResult = new LoginBean();
        expResult.setSuccess(Boolean.TRUE);
        
        String result = instance.login(username, password);
        Gson gson = new Gson();
        LoginBean loginResult = gson.fromJson(result, LoginBean.class);
        assertEquals(expResult.isSuccess(), loginResult.isSuccess());
    }

    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetAlumno() {
        System.out.println("testGetAlumno");
        String username = "6150";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        AlumnoBean expResult = new AlumnoBean();
        String result = instance.getAlumno(username);
        Gson gson = new Gson();
        AlumnoBean alumnoResult = gson.fromJson(result, AlumnoBean.class);
        
        assertEquals(expResult.getId(), alumnoResult.getId());
    }

    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetPeriodos() {
        System.out.println("testGetPeriodos");
        String alumnoId = "8245";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        int periodos = 1;
        String result = instance.getPeriodos(alumnoId);
        Gson gson = new Gson();
        ListadoPeriodoBean listadoPeriodoResult = gson.fromJson(result, ListadoPeriodoBean.class);
        
        assertEquals(periodos, listadoPeriodoResult.getPeriodos().size());
    }
    
    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetNotas() {
        System.out.println("testGetNotas");
        String alumnoId = "8245";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        int periodos = 1;
        String result = instance.getNotas(alumnoId);
        Gson gson = new Gson();
        ListadoPeriodoBean listadoPeriodoResult = gson.fromJson(result, ListadoPeriodoBean.class);
        
        assertEquals(periodos, listadoPeriodoResult.getPeriodos().size());
    }
    
    
    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetSimulacro() {
        System.out.println("testGetSimulacro");
        String alumnoId = "12468";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        int simulacros = 1;
        String result = instance.getSimulacro(alumnoId);
        Gson gson = new Gson();
        ListadoSimulacroBean resultList = gson.fromJson(result, ListadoSimulacroBean.class);
        
        assertEquals(simulacros, resultList.getSimulacros().size());
    }
    
    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetAsistencia() {
        System.out.println("testGetAsistencia");
        String alumnoId = "8245";
        String mes = "9";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        int detalle = 25;
        String result = instance.getAsistencia(alumnoId, mes);
        Gson gson = new Gson();
        AsistenciaBean resultList = gson.fromJson(result, AsistenciaBean.class);
        
        assertEquals(detalle, resultList.getDetalleAsistencia().size());
    }
    
    /**
     * Test of login method, of class GestionAcademicaResource.
     */
    @Test
    public void testGetPago() {
        System.out.println("testGetPago");
        String alumnoId = "8245";
        GestionAcademicaResource instance = new GestionAcademicaResource();
        int detalle = 11;
        String result = instance.getPago(alumnoId);
        Gson gson = new Gson();
        ListadoPagoBean resultList = gson.fromJson(result, ListadoPagoBean.class);
        
        assertEquals(detalle, resultList.getPagos().size());
    }
}
