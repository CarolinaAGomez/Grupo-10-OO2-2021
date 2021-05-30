package com.Grupo10OO22021.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.RodadoConverter;
import com.Grupo10OO22021.entities.Rodado;
import com.Grupo10OO22021.models.RodadoModel;
import com.Grupo10OO22021.repository.IRodadoRepository;
import com.Grupo10OO22021.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{

	@Autowired
	private RodadoConverter rodadoConverter;
	
	@Autowired 
	private IRodadoRepository rodadoRepository;
	
	@Override
	public RodadoModel inserOrUpdate(RodadoModel rodadoModel) {
		Rodado rodado = (Rodado) rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		return rodadoConverter.entityToModel(rodado);
	}

	@Override
	public List<Rodado> getAll() {
		
		return rodadoRepository.findAll();
	}

}
