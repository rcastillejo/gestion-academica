/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gestionacademica.proxy;

/**
 *
 * @author rcastillejo
 */
public class ColegioProxy extends AbstractProxy {

    private static final String URL = "http://localhost:8080/ColegioService/webresources";
    private static final String SERVICE = "/Colegio";
    private static final String PATH_ALUMNO = "/alumno";
    private static final String PATH_NOTA = "/notas";
    private static final String PATH_SIMULACRO = "/simulacro";
    private static final String PATH_ASISTENCIA = "/asistencia";

    public ColegioProxy() {
        super(URL, SERVICE);
    }

    public String getAlumno(String alumnoId) {
        return get(PATH_ALUMNO, '/' + alumnoId);
    }

    public String putAlumno(String content) {
        return put(PATH_ALUMNO, content);
    }

    public String getNotas(String alumnoId) {
        return get(PATH_NOTA, '/' + alumnoId);
    }

    public String getSimulacro(String alumnoId) {
        return get(PATH_SIMULACRO, '/' + alumnoId);
    }

    public String getAsistencia(String alumnoId) {
        return get(PATH_ASISTENCIA, '/' + alumnoId);
    }

}
