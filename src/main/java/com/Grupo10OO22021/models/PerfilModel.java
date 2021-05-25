package com.Grupo10OO22021.models;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.entities.Usuario;

public class PerfilModel {
	
	private int idPerfil;
	private String nombreRol;
	private Set<Usuario> usuarios = new HashSet<>();
		
	public PerfilModel() {}

	public PerfilModel(int idPerfil, String nombreRol) {
		super();
		this.setIdPerfil(idPerfil);
		this.nombreRol = nombreRol;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
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

	@Override
	public String toString() {
		return "idPerfil: " + idPerfil + "\nnombreRol: " + nombreRol;
	}

	
}
