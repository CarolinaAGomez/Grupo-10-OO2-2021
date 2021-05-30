package com.Grupo10OO22021.services;

import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.models.PermisoModel;



public interface IPermisoService {
	
	
public PermisoModel insertOrUpdate(PermisoModel permiso);
	
	
	public PermisoModel traerPermisoxPersona(int idPersona);


}
