package com.sacooliveros.intranet.controller;

import com.sacooliveros.gestionacademica.bean.AsistenciaBean;
import com.sacooliveros.gestionacademica.bean.DetalleAsistenciaBean;


public class AsistenciaController  extends GestionAcademicaService{
	
	private static final String serviceName = "asistencia";	
	public static AsistenciaController instance = null;
	private AsistenciaBean session;
	private DetalleAsistenciaBean itemSelected;
	
	private AsistenciaController() {
		super(serviceName);
	}
	
	public static AsistenciaController getInstance() {
		if (instance == null) {
			instance = new AsistenciaController();
		}
		return instance;
	}
	
	public AsistenciaBean consultar(String alumnoId, String mesId){
		String params = '/' + alumnoId + '/' + mesId;
		AsistenciaBean responseBean = get(params, AsistenciaBean.class);
		if (responseBean ==null){
			throw new RuntimeException("Error de conexion");		
		}
		createSession(responseBean);
		return responseBean;
	}

	private void createSession(AsistenciaBean bean){
		session = bean;
	}
	
	public AsistenciaBean getSession(){
		return session;
	}
	
	public void select(int pos){
		itemSelected = session.getDetalleAsistencia().get(pos);
	}
	
	public DetalleAsistenciaBean getItemSelected(){
		return itemSelected;
	}
}
