package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.models.PermisoModel;

@Component
public class PermisoConverter {
	
	@Autowired
	private PersonaConverter personaConverter;
	@Autowired
	private LugarConverter lugarConverter;
	
	
	
	public PermisoModel entityToModel(Permiso permiso) {
		
		return new PermisoModel(permiso.getIdPermiso(),
								personaConverter.entityToModel(permiso.getPedido()),
								permiso.getFecha()
//								lugarConverter.entityToModel(permiso.getDesdeHasta())	// COMO ES UNA LISTA EL "DESDE HASTA" SE HACE <<<<---- ASI O???
//								HICE UN NUEVO CONSTRUCTOR SIN EL GET DPS TENGO Q FIJARME BIEN COMO ES
								);
				
	}
	
	public Permiso modelToEntity(PermisoModel permisoModel) {
		
		return new Permiso(permisoModel.getIdPermiso(),
							personaConverter.modelToEntity(permisoModel.getPedido()),
							permisoModel.getFecha(),
							permisoModel.getDesdeHasta() 							// <<<----- SE HACE ASI???
				);
				
				
	}
	
	
	
	

}
