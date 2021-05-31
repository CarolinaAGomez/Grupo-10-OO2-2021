package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;

public interface IPermisoService {

	public List<PermisoModel> findAll();

	public PermisoModel insertOrUpdate(PermisoModel permiso);

	public PermisoModel traerPermisoxPersona(int idPersona);

}
