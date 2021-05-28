package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.PermisoDiarioModel;

@Component
public class PermisoDiarioConverter {

	@Autowired
	private PersonaConverter personaConverter;

	public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {

		return new PermisoDiarioModel(permisoDiario.getIdPermiso(),
										personaConverter.entityToModel(permisoDiario.getPedido()), 
										permisoDiario.getFecha(),
										// FALTA EL GET DE LUGAR
										permisoDiario.getMotivo());
	}

	public PermisoDiario modelToEntity (PermisoDiarioModel permisoDiarioModel) {
		
		return new PermisoDiario(permisoDiarioModel.getIdPermiso(),
									personaConverter.modelToEntity(permisoDiarioModel.getPedido()),
									permisoDiarioModel.getFecha(),
									//FALTA EL GET DE LUGAR
									permisoDiarioModel.getMotivo()
									);
				
		
	}

}
