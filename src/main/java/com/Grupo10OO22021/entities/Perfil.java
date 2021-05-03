package com.Grupo10OO22021.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Perfil {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto-increment igual a true
	private long idPerfil;
	
	private String nombreRol;
	
	@OneToMany(mappedBy="perfil")  //1 ROL TIENE MUCHOS USUARIOS  . perfil ES DE LA LISTA DE USUARIOS
	private Set<Usuario> usuarios;// =new HashSet<Usuario>();
	
	
	public Perfil() {}


	public Perfil(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}
	


	public long getIdPerfil() {
		return idPerfil;
	}


	protected void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}

/*
	public Perfil(long idPerfil, String nombreRol) {
		super();
		this.idPerfil = idPerfil;
		this.nombreRol = nombreRol;
	}
*/


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


