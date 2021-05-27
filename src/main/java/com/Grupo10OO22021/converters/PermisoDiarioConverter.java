package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.PermisoDiarioModel;

@Component
public class PermisoDiarioConverter {
	
	public PermisoDiarioModel modelToEntity (PermisoDiario permisoDiario) {
		
		return new PermisoDiarioModel(permisoDiario.getMotivo());
	}
	
	public PermisoDiario entityTomodel (PermisoDiarioModel permisoDiarioModel) {
		
		return new PermisoDiario(permisoDiarioModel.getMotivo());
	}

}
