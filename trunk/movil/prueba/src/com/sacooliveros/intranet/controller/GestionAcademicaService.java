package com.sacooliveros.intranet.controller;

import com.google.gson.Gson;
import com.sacooliveros.intranet.http.HttpControl;

public abstract class GestionAcademicaService {
	
	private static final String URL = "http://192.168.1.103:8080/GestionAcademicaService/webresources/GestionAcademica/"; 
	private final String serviceUrl;
	
	public GestionAcademicaService(String service){		
		this.serviceUrl = URL + service;
	}
	
	public String getServiceUrl(){
		return this.serviceUrl;
	}
	
	public <T> T get(String params, Class<T> classOfT){
		Gson gs = new Gson();

		String response = HttpControl.getJson(this.serviceUrl + params);
		T responseBean = gs.fromJson(response, classOfT);
		return responseBean;
		
	}
	

	public <T> T post(String json, Class<T> classOfT){
		Gson gs = new Gson();

		String response = HttpControl.getJson(this.serviceUrl, json);
		T responseBean = gs.fromJson(response, classOfT);
		return responseBean;		
	}
	

	/*public <T> T update(String queryString, String json, Class<T> classOfT){
		Gson gs = new Gson();

		String response = HTTPControl.getJson(queryString, json);
		T responseBean = gs.fromJson(response, classOfT);
		return responseBean;		
	}


	public <T> T delete(String queryString, String json, Class<T> classOfT){
		Gson gs = new Gson();

		String response = HTTPControl.getJson(queryString, json);
		T responseBean = gs.fromJson(response, classOfT);
		return responseBean;		
	}*/ 

}
