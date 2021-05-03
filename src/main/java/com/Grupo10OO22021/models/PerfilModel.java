package com.Grupo10OO22021.models;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.entities.Usuario;



public class PerfilModel {
	

	
	
	private long idPerfil;
	private String nombreRol;
	private Set<Usuario> usuarios = new HashSet<>();
	
	
	public PerfilModel() {}


	public PerfilModel(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}


	public long getIdPerfil() {
		return idPerfil;
	}


	protected void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}


	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



}
