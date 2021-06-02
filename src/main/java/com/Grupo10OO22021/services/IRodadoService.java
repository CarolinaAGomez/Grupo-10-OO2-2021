package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.models.RodadoModel;

public interface IRodadoService {

	public RodadoModel inserOrUpdate (RodadoModel rodado);
	
	
	public List<RodadoModel> getAll();
}
