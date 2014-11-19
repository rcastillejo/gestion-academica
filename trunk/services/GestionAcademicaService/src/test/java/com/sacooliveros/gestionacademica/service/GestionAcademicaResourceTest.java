/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gestionacademica.service;

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
        String expResult = "1";
        String result = instance.login(username, password);
        assertEquals(expResult, result);
    }

    
}
