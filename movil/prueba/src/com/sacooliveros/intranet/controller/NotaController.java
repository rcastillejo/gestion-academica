package com.sacooliveros.intranet.controller;

import com.sacooliveros.gestionacademica.bean.ListadoPeriodoBean;
import com.sacooliveros.gestionacademica.bean.PeriodoBean;


public class NotaController  extends GestionAcademicaService{
	
	private static final String serviceName = "notas";	
	public static NotaController instance = null;
	private ListadoPeriodoBean session;
	private PeriodoBean itemSelected;
	
	private NotaController() {
		super(serviceName);
	}
	
	public static NotaController getInstance() {
		if (instance == null) {
			instance = new NotaController();
		}
		return instance;
	}
	
	public ListadoPeriodoBean consultar(String alumnoId){
		String params = '/' + alumnoId;
		ListadoPeriodoBean responseBean = get(params, ListadoPeriodoBean.class);
		if (responseBean ==null){
			throw new RuntimeException("Error de conexion");		
		}
		createSession(responseBean);
		return responseBean;
	}

	private void createSession(ListadoPeriodoBean bean){
		session = bean;
	}
	
	public ListadoPeriodoBean getSession(){
		return session;
	}
	
	public void select(int pos){
		itemSelected = session.getPeriodos().get(pos);
	}
	
	public PeriodoBean getItemSelected(){
		return itemSelected;
	}
}
