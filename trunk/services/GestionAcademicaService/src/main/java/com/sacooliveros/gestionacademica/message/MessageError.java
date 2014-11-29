/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sacooliveros.gestionacademica.message;

/**
 *
 * @author Ricardo
 */
public interface MessageError {
    
    String LOGIN_ERROR = "Error usuario y/o clave";
    String GET_ALUMNO = "Error al obtener alumno:";
    String LOGIN = "Error al realizar login:";
    String GET_PERIODOS = "Error al obtener periodos del alumno:";
    String GET_NOTAS = "Error al obtener notas del alumno:";
    String GET_ASISTENCIA = "Error al obtener asistencia del alumno:";
    String GET_SIMULACRO = "Error al obtener simulacros del alumno:";
    String GET_PAGO = "Error al obtener pagos del alumno:";
    
}
