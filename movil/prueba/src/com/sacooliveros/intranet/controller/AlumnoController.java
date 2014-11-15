package com.sacooliveros.intranet.controller;

import com.sacooliveros.intranet.bean.AlumnoBean;

public class AlumnoController  extends GestionAcademicaService{
	
	private static final String serviceName = "alumno";	
	public static AlumnoController instance = null;
	
	private AlumnoController() {
		super(serviceName);
	}
	
	public static AlumnoController getInstance() {
		if (instance == null) {
			instance = new AlumnoController();
		}
		return instance;
	}
	
	public AlumnoBean consultar(String alumnoId){
		String params = '/' + alumnoId;
		AlumnoBean responseBean = get(params, AlumnoBean.class);
		if (responseBean ==null){
			throw new RuntimeException("Error de conexion");		
		}
		return responseBean;
	}
		
}
