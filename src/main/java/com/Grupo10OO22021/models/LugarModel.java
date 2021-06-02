package com.Grupo10OO22021.models;

import java.util.Set;

import com.Grupo10OO22021.entities.Permiso;

public class LugarModel {

	private int idLugar;
	private String lugar;
	private String codigoPostal;
	private Set<PermisoModel> permiso;

	public LugarModel() {
		super();
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

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLugar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LugarModel other = (LugarModel) obj;
		if (idLugar != other.idLugar)
			return false;
		return true;
	}
/*
	public void agregarPermisoaLugar( PermisoModel p) {
		permiso.add(p);
		
	}
	*/

	@Override
	public String toString() {
		return "LugarModel [codigoPostal=" + codigoPostal + ", idLugar=" + idLugar + ", lugar=" + lugar  + "]";
	}

}
