package com.Grupo10OO22021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PermisoPeriodo")
@PrimaryKeyJoinColumn(name = "idPermiso")
public class PermisoPeriodo extends Permiso {

	@Column(name = "cantDias")
	private int cantDias;
	@Column(name = "vacaciones")
	private boolean vacaciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRodado")
	private Rodado rodado;

	public PermisoPeriodo() {
		super();
	}

	public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public PermisoPeriodo(int idPermiso, Persona persona, LocalDate fecha, Set<Lugar> desdeHasta, int cantDias,
			boolean vacaciones, Rodado rodado) {
		super(idPermiso, persona, fecha, desdeHasta);
		// TODO Auto-generated constructor stub
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public PermisoPeriodo(int idPermiso, Persona persona, LocalDate fecha, int cantDias, boolean vacaciones,
			Rodado rodado) {
		super(idPermiso, persona, fecha);
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
