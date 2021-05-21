package com.Grupo10OO22021.models;



public class UsuarioModel {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String mail;
	private String username; 
	private String password;
	private PerfilModel perfil;
	public UsuarioModel() {
	}
	
	public UsuarioModel(long idUsuario, String nombre, String apellido, int dni, String mail, String username, String password) {
		this.setIdUsuario(idUsuario);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}

	public UsuarioModel(long idUsuario, String nombre, String apellido, int dni, String mail, String username, String password,PerfilModel perfil) {
		this.setIdUsuario(idUsuario);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
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

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "idUsuario: " + idUsuario + "\napellido: " + apellido + "\nnombre: " + nombre + "\ndni: " + dni + "\nmail: " + mail
				+"\nusername: " + username +  "\npassword: " + password + "\nperfil: " + perfil;
	}
}


