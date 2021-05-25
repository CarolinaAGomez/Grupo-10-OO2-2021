package com.Grupo10OO22021.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "dni")
	private int dni;

	@Column(name = "mail")
	private String mail;

	@Column(name = "username")
	private String username; 

	@Column(name = "password")
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY) //1 USUARIO TIENE UN ROL. IdPerfil ES DE LA pk de rol
	@JoinColumn(name="idPerfil")
	private Perfil perfil;
	 

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	
	public Usuario () {}
	
	
	public Usuario(long idUsuario,String nombre, String apellido, int dni, String mail, String username, String password) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(long idUsuario,String nombre, String apellido, int dni, String mail, String username, String password,Perfil perfil) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.perfil  = perfil;
	}

	public Usuario( String username, String password, Perfil perfil) {
		super();
		this.username = username;
		this.password = password;
		this.perfil=perfil;
	}

	

	public long getIdUsuario() {
		return idUsuario;
	}


	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	@Override
	public String toString() {
		return "Usuario [dni=" + dni + "]";
	}



	
	
	
	
}
