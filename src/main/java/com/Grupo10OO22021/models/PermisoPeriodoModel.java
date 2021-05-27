package com.Grupo10OO22021.models;

import javax.persistence.Column;

import com.Grupo10OO22021.entities.Rodado;

public class PermisoPeriodoModel {

	private int cantDias;
	private boolean vacaciones;
	private Rodado rodado;

	public PermisoPeriodoModel() {

	}

	public PermisoPeriodoModel(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}

}
