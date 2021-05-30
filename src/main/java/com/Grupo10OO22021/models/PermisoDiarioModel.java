package com.Grupo10OO22021.models;

import java.time.LocalDate;
import java.util.Set;

public class PermisoDiarioModel extends PermisoModel{
	

	private String motivo;

	public PermisoDiarioModel() {
		super();
	}

	public PermisoDiarioModel(int idPermiso, PersonaModel persona, LocalDate fecha, Set<LugarModel> desdeHasta,String motivo) {
		super(idPermiso, persona, fecha, desdeHasta);
		this.motivo = motivo;
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

	
	
	
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoDiarioModel other = (PermisoDiarioModel) obj;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		return true;
	}
	
	

}
