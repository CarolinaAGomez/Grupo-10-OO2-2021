package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;

@Component("permisoDiarioConverter")
public class PermisoDiarioConverter {

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {
		Set<LugarModel> desdeHasta = new HashSet<>();
		for(Lugar l : permisoDiario.getDesdeHasta()){
			desdeHasta.add(lugarConverter.entityToModel(l));
		}
		return new PermisoDiarioModel(permisoDiario.getIdPermiso(),
										personaConverter.entityToModel(permisoDiario.getPedido()), 
										permisoDiario.getFecha(),
										desdeHasta,
										permisoDiario.getMotivo());
	}

	public PermisoDiario modelToEntity (PermisoDiarioModel permisoDiarioModel) {
		Set<Lugar> desdeHasta = new HashSet<>();
		for(LugarModel l : permisoDiarioModel.getDesdeHasta()){
			desdeHasta.add(lugarConverter.modelToEntity(l));
		}

		return new PermisoDiario(permisoDiarioModel.getIdPermiso(),
									personaConverter.modelToEntity(permisoDiarioModel.getPedido()),
									permisoDiarioModel.getFecha(),
									desdeHasta,
									permisoDiarioModel.getMotivo()
									);
				
		
	}

}
