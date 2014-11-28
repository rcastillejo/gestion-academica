package com.sacooliveros.intranet.controller;

import com.sacooliveros.gestionacademica.bean.AlumnoBean;

public class AlumnoController  extends GestionAcademicaService{
	
	private static final String serviceName = "alumno";	
	public static AlumnoController instance = null;
	private AlumnoBean session;
	
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
		createSession(responseBean);
		return responseBean;
	}

	private void createSession(AlumnoBean bean){
		session = bean;
	}
	
	public AlumnoBean getSession(){
		return session;
	}
}
