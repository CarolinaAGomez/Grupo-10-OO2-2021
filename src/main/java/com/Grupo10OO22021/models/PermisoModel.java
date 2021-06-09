package com.Grupo10OO22021.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


public class PermisoModel {

	private int idPermiso;
	private PersonaModel pedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPermiso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoModel other = (PermisoModel) obj;
		if (idPermiso != other.idPermiso)
			return false;
		return true;
	}

	/*public void agregarLugaraPermiso(LugarModel l) {
		  desdeHasta.add(l);
		
	}*/
	
	
	
}
