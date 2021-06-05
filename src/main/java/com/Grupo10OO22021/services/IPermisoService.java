package com.Grupo10OO22021.services;

import java.util.List;
import java.util.Set;

import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;


public interface IPermisoService {

	public PermisoModel insertOrUpdate(PermisoModel permiso);

	public Set<PermisoModel> traerPermisoxPersona(int idPersona);
}
