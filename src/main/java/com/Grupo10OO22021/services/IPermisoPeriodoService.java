package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {
	
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permiso);
	
	public List<PermisoPeriodoModel> findByIdRodado(int idRodado);
}
