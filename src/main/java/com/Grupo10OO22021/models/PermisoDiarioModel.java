package com.Grupo10OO22021.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.entities.Persona;

public class PermisoDiarioModel extends PermisoModel{
	

	private String motivo;

	public PermisoDiarioModel() {
		super();
	}

	

	public PermisoDiarioModel(String motivo) {
		super();
		this.motivo = motivo;
	}



	public PermisoDiarioModel(int idPermiso, PersonaModel persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		super(idPermiso, persona, fecha, desdeHasta);
		// TODO Auto-generated constructor stub
	}

	


	public PermisoDiarioModel(int idPermiso, PersonaModel pedido, LocalDate fecha, String motivo) {
		super(idPermiso, pedido, fecha);
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
