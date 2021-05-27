package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.PermisoPeriodo;
import com.Grupo10OO22021.models.PermisoPeriodoModel;

@Component
public class PermisoPeriodoConverter {
	
@Autowired
private RodadoConverter rodadoConverter;
@Autowired
private PersonaConverter personaConverter;
	
	public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {
		
		return new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(),
										personaConverter.entityToModel(permisoPeriodo.getPedido()),
										permisoPeriodo.getFecha(),
										// FALTA EL SET DE LUGAR
										permisoPeriodo.getCantDias(),
										permisoPeriodo.isVacaciones(),
										rodadoConverter.entityToModel(permisoPeriodo.getRodado())
										);
		
		}
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {
		
		return new PermisoPeriodo(permisoPeriodoModel.getIdPermiso(),
									personaConverter.modelToEntity(permisoPeriodoModel.getPedido()),
									permisoPeriodoModel.getFecha(),
									//FALTA EL SET DE LUGAR
									permisoPeriodoModel.getCantDias(),
									permisoPeriodoModel.isVacaciones(),
									rodadoConverter.modelToEntity(permisoPeriodoModel.getRodado())
									);
		
	}

}
