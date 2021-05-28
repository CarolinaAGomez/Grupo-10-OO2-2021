package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoModel;

@Component("permisoConveter")
public class PermisoConverter {
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	
	
	public PermisoModel entityToModel(Permiso permiso) {
		Set<LugarModel> desdeHasta = new HashSet<>();
		for(Lugar l : permiso.getDesdeHasta()){
			desdeHasta.add(lugarConverter.entityToModel(l));
		}
	
		return new PermisoModel(permiso.getIdPermiso(),
								personaConverter.entityToModel(permiso.getPedido()),
								permiso.getFecha(),
								desdeHasta
								);
				
	}
	
	public Permiso modelToEntity(PermisoModel permisoModel) {
		Set<Lugar> desdeHasta = new HashSet<>();
		for(LugarModel l : permisoModel.getDesdeHasta()){
			desdeHasta.add(lugarConverter.modelToEntity(l));
		}
		return new Permiso(permisoModel.getIdPermiso(),
							personaConverter.modelToEntity(permisoModel.getPedido()),
							permisoModel.getFecha(),
							desdeHasta
				);
				
				
	}
	
	
	
	

}
