package com.sacooliveros.intranet.bean;

public class MesBean {
	private String id;
	private String nombre;
	
	public MesBean(){}
	
	public MesBean(String id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
