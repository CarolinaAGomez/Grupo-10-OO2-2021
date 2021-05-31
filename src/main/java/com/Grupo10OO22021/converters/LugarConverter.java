package com.Grupo10OO22021.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoModel;

@Component("lugarConverter")
public class LugarConverter {
	
	

	public Lugar modelToEntity(LugarModel lugarModel) {
		
		return new Lugar(lugarModel.getIdLugar(), lugarModel.getLugar(), lugarModel.getCodigoPostal());
		
	}
	
	public LugarModel entityToModel(Lugar lugar) {
		
		return new LugarModel(lugar.getIdLugar(), lugar.getLugar(), lugar.getCodigoPostal());
		
	}
	
	/*
	private PermisoConverter permisoConverter;
	
	public LugarModel entityToModel(Lugar lugar) {
		Set<PermisoModel> permiso = new HashSet<>();
		for(Permiso p : lugar.getPermiso()){
			permiso.add(permisoConverter.entityToModel(p));
		}
	
		return new LugarModel(lugar.getIdLugar(),
								lugar.getLugar(),
								lugar.getCodigoPostal(),
								permiso
								);
	}
	
	
	public Lugar entityToModel(LugarModel lugarModel) {
		Set<Permiso> permiso = new HashSet<>();
		for(PermisoModel p : lugarModel.getPermiso()){
			permiso.add(permisoConverter.modelToEntity(p));
		}
	
		return new Lugar(lugarModel.getIdLugar(),
				lugarModel.getLugar(),
				lugarModel.getCodigoPostal(),
								permiso
								);
	}
	
	*/
	
	
}




