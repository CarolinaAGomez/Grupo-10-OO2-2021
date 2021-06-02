package com.Grupo10OO22021.services;

import java.util.Set;

import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.models.PersonaModel;

public interface IPermisoDiarioService {

	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso);

	public Set<PermisoDiarioModel> findByPedido(int idPersona);
}
