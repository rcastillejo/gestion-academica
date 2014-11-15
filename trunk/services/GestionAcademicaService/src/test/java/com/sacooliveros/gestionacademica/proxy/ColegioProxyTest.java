/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gestionacademica.proxy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rcastillejo
 */
public class ColegioProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ColegioProxyTest.class);
    
    public ColegioProxyTest() {
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
     * Test of getAlumno method, of class ColegioProxy.
     */
    //@Test
    public void testGetAlumno() {
        log.debug("getAlumno");
        String alumnoId = "1";
        ColegioProxy instance = new ColegioProxy();
        String result = instance.getAlumno(alumnoId);
        log.debug("result:"+result);
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Test of putAlumno method, of class ColegioProxy.
     */
    //@Test
    public void testPutAlumno() { 
    }

    /**
     * Test of getNotas method, of class ColegioProxy.
     */
    //@Test
    public void testGetNotas() { 
        log.debug("testGetNotas");
        String alumnoId = "1";
        ColegioProxy instance = new ColegioProxy();
        String result = instance.getNotas(alumnoId);
        log.debug("testGetNotas result:"+result);
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Test of getSimulacro method, of class ColegioProxy.
     */
    //@Test
    public void testGetSimulacro() {  
        log.debug("testGetSimulacro");
        String alumnoId = "1";
        ColegioProxy instance = new ColegioProxy();
        String result = instance.getSimulacro(alumnoId);
        log.debug("result:"+result);
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Test of getAsistencia method, of class ColegioProxy.
     */
    //@Test
    public void testGetAsistencia() { 
        log.debug("testGetAsistencia");
        String alumnoId = "1";
        ColegioProxy instance = new ColegioProxy();
        String result = instance.getAsistencia(alumnoId);
        log.debug("result:"+result);
        assertTrue(result != null && !result.isEmpty());
    }
    
}
