package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {

	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(),perfil.getNombreRol());	
	}
	
	public Perfil modeltoEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(),perfilModel.getNombreRol());
	}
}
