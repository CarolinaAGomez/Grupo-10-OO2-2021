package com.Grupo10OO22021.models;

import java.util.Set;

public class LugarModel {

	private int idLugar;
	private String lugar;
	private String codigoPostal;
	private Set<PermisoModel> permiso;

	public LugarModel() {
		super();
	}

	public LugarModel(int idLugar, String lugar, String codigoPostal, Set<PermisoModel> permiso) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
		this.permiso = permiso;
	}
	
	public LugarModel(int idLugar, String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Set<PermisoModel> getPermiso() {
		return permiso;
	}

	public void setPermiso(Set<PermisoModel> permiso) {
		this.permiso = permiso;
	}

	

}
