package com.Grupo10OO22021.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.PerfilConverter;
import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.models.PerfilModel;
import com.Grupo10OO22021.repository.IPerfilRepository;
import com.Grupo10OO22021.services.IPerfilService;


@Service
public class PerfilService implements IPerfilService{

	@Autowired
	IPerfilRepository perfilRepository;
	
	@Autowired
	PerfilConverter perfilConverter;
	
	@Override
	public List<Perfil> GetAll() {
		return (List<Perfil>)perfilRepository.findAll();
	}
	
	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		Perfil perfil = (Perfil) perfilRepository.save(perfilConverter.modeltoEntity(perfilModel));
		return perfilConverter.entityToModel(perfil);
	}

	@Override
	public boolean remove(PerfilModel perfilModel) {
		try {
			perfilRepository.delete(perfilConverter.modeltoEntity(perfilModel));;
			return true;
		} catch(Exception he) {
			return false;
		}
	}

	@Override
	public boolean remove(int id) {
		try {
			System.out.println(id);
			perfilRepository.deleteById(id);
			return true;
		}catch(Exception he) {
			return false;
		}
	}
	
	@Override
	public PerfilModel findById(int id) {
		PerfilModel perfilModel = perfilConverter.entityToModel(perfilRepository.findByIdPerfil(id));
		return perfilModel;
	}
}
	


/*
 * 
 * Entidades = base de datos
 * Modelos = Capa de backend*/
