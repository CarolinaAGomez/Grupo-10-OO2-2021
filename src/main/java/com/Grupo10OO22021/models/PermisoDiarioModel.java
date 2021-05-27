package com.Grupo10OO22021.models;

import javax.persistence.Column;

public class PermisoDiarioModel {
	

	private String motivo;

	public PermisoDiarioModel() {
		super();
	}

	public PermisoDiarioModel(String motivo) {
		super();
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [motivo=" + motivo + "]";
	}
	
	

}
