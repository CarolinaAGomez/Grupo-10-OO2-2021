package com.Grupo10OO22021.services;

import java.util.Set;

import com.Grupo10OO22021.models.LugarModel;

public interface ILugarService {
	
	public Set<LugarModel> getAll();

	public LugarModel findByIdLugar(int id);
}
