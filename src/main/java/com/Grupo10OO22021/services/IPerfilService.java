package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.models.PerfilModel;

public interface IPerfilService {

	public List<Perfil> GetAll();
	
	public PerfilModel insertOrUpdate(PerfilModel perfinModel);
	
	public boolean remove(int id);

	public boolean remove(PerfilModel perfilModel);
	
	public PerfilModel findById(int id);
}
