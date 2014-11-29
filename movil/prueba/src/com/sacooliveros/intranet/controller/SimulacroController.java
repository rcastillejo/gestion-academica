package com.sacooliveros.intranet.controller;

import com.sacooliveros.gestionacademica.bean.ListadoSimulacroBean;


public class SimulacroController  extends GestionAcademicaService{
	
	private static final String serviceName = "simulacro";	
	public static SimulacroController instance = null;
	private ListadoSimulacroBean session;
	
	private SimulacroController() {
		super(serviceName);
	}
	
	public static SimulacroController getInstance() {
		if (instance == null) {
			instance = new SimulacroController();
		}
		return instance;
	}
	
	public ListadoSimulacroBean consultar(String alumnoId){
		String params = '/' + alumnoId;
		ListadoSimulacroBean responseBean = get(params, ListadoSimulacroBean.class);
		if (responseBean ==null){
			throw new RuntimeException("Error de conexion");		
		}
		createSession(responseBean);
		return responseBean;
	}

	private void createSession(ListadoSimulacroBean bean){
		session = bean;
	}
	
	public ListadoSimulacroBean getSession(){
		return session;
	}
}
