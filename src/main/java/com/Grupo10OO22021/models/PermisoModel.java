package com.Grupo10OO22021.models;

import java.time.LocalDate;
import java.util.Set;

public class PermisoModel {

	private int idPermiso;
	private PersonaModel pedido;
	private LocalDate fecha;
	private Set<LugarModel> desdeHasta;

	public PermisoModel() {}

	public PermisoModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}
	public PermisoModel(int idPermiso, PersonaModel pedido, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
	}
	public int getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}
	public PersonaModel getPedido() {
		return pedido;
	}
	public void setPedido(PersonaModel pedido) {
		this.pedido = pedido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}
	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}
}
