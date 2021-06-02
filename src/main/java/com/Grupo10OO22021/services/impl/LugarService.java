package com.Grupo10OO22021.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.repository.ILugarRepository;
import com.Grupo10OO22021.services.ILugarService;


@Service("lugarService")
public class LugarService implements ILugarService {
	
	
	@Autowired
	private ILugarRepository lugarRepository;

	@Override
	public List<Lugar> getAll() {
		
		return lugarRepository.findAll();
	}

}
