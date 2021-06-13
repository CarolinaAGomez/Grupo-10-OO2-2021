package com.Grupo10OO22021.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class RodadoModel {


	private int idRodado;
	@NotEmpty
	//@Pattern(regexp = "^[A]{1}\\[A-E]{1}\\[0-9]{3}\\[A]{1}\\[A]{1}$")
	private String dominio;
	private String vehiculo;

	public RodadoModel() {
	}

	public RodadoModel(int idRodado, String dominio, String vehiculo) {
		super();
		this.idRodado = idRodado;
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", dominio=" + dominio + ", vehiculo=" + vehiculo + "]";
	}

}