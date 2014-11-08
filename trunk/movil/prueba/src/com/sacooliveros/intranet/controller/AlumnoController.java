package com.sacooliveros.intranet.controller;

import com.google.gson.Gson;
import com.sacooliveros.intranet.bean.AlumnoBean;
import com.sacooliveros.intranet.http.HTTPControl;

public class AlumnoController {

	public static String Url= "http://localhost:8080/GestionAcademicaService/webresources/";
	public static AlumnoController instance = null;
	
	public AlumnoBean currUsuario = null;
	
	public static AlumnoController getInstance() {
		if (instance == null) {
			instance = new AlumnoController();
		}
		return instance;
	}

	public AlumnoController() {
		
	}

	public String consultarDatos(String alumnoId){
		currUsuario = null;
		
		Gson gs = new Gson();
		//String json = gs.toJson(bean);
		String json = "";
 
		String response = HTTPControl.getJson(Url+"alumno/"+alumnoId, json);
		AlumnoBean responseBean = gs.fromJson(response, AlumnoBean.class);
		
		if (responseBean ==null){
			return "Error de conexion";
		}else{
			currUsuario = responseBean;
		}
		return "";
	}
		
}
