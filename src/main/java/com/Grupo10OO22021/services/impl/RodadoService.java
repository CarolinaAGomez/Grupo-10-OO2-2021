package com.Grupo10OO22021.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.RodadoConverter;
import com.Grupo10OO22021.entities.Rodado;
import com.Grupo10OO22021.models.RodadoModel;
import com.Grupo10OO22021.repository.IRodadoRepository;
import com.Grupo10OO22021.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	@Autowired 
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@Override
	public RodadoModel inserOrUpdate(RodadoModel rodadoModel) {
		Rodado rodado = (Rodado) rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		return rodadoConverter.entityToModel(rodado);
	}

	@Override
	public List<RodadoModel> getAll(){
		List<RodadoModel> rodados = new ArrayList<>();
		for(Rodado r : rodadoRepository.findAll()){
			rodados.add(rodadoConverter.entityToModel(r));
		}
		return rodados;
	}

}
