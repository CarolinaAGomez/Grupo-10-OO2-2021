package com.Grupo10OO22021.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.LugarConverter;
import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.repository.ILugarRepository;
import com.Grupo10OO22021.services.ILugarService;


@Service("lugarService")
public class LugarService implements ILugarService {
	
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Override
	public Set<LugarModel> getAll() {
		Set<LugarModel> lugares = new HashSet<>();
		for(Lugar l : lugarRepository.findAll()){
			lugares.add(lugarConverter.entityToModel(l));
		}
		return lugares;
	}

	@Override 
	public LugarModel findByIdLugar(int id){
		return lugarConverter.entityToModel(lugarRepository.findByIdLugar(id));
	}

}
