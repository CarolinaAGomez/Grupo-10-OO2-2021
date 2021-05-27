package com.Grupo10OO22021.models;

import java.time.LocalDate;
import java.util.Set;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.Rodado;

public class PermisoModel {

	private int idPermiso;
	private PersonaModel pedido;
	private LocalDate fecha;
	private Set<Lugar> desdeHasta;

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<Lugar> desdeHasta) {
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

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}

}
