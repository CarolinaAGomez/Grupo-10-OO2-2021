package com.Grupo10OO22021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permisoDiario")
@PrimaryKeyJoinColumn(name = "idPermiso")
public class PermisoDiario extends Permiso {

	@Column(name = "motivo")
	private String motivo;

	public PermisoDiario() {
		super();
	}

	public PermisoDiario(String motivo) {
		super();
		this.motivo = motivo;
	}
	

	public PermisoDiario(int idPermiso, Persona persona, LocalDate fecha, Set<Lugar> desdeHasta, String motivo) {
		super(idPermiso, persona, fecha, desdeHasta);
		// TODO Auto-generated constructor stub
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
