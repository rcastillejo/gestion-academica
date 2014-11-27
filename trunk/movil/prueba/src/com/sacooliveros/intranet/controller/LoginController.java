package com.sacooliveros.intranet.controller;

import com.sacooliveros.gestionacademica.bean.LoginBean;
import com.sacooliveros.intranet.bean.UsuarioBean;

public class LoginController  extends GestionAcademicaService{
	
	private static final String serviceName = "login";	
	public static LoginController instance = null;
	private UsuarioBean session;
	
	private LoginController() {
		super(serviceName);
	}
	
	public static LoginController getInstance() {
		if (instance == null) {
			instance = new LoginController();
		}
		return instance;
	}
	
	public LoginBean login(String usuario, String password){
		String params = '/' + usuario + '/' + password;
		LoginBean responseBean = get(params, LoginBean.class);
		if (responseBean ==null){
			throw new RuntimeException("Error de conexion");		
		}
		createSession(responseBean.getCodigoAlumno());
		return responseBean;
	}
		
	private void createSession(String username){
		session = new UsuarioBean(); 
		session.setUsername(username);
	}
	
	public UsuarioBean getSession(){
		return session;
	}
}
