package com.Grupo10OO22021.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.PermisoPeriodoConverter;
import com.Grupo10OO22021.entities.PermisoPeriodo;
import com.Grupo10OO22021.models.PermisoPeriodoModel;
import com.Grupo10OO22021.repository.IPermisoPeriodoRepository;
import com.Grupo10OO22021.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService {
	
	@Autowired
	private PermisoPeriodoConverter permisoPeriodoConverter;
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Override
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permiso) {
		 return permisoPeriodoConverter.entityToModel(permisoPeriodoRepository.save(permisoPeriodoConverter.modelToEntity(permiso)));
	}

	@SuppressWarnings("null")
	@Override
	public List<PermisoPeriodoModel> findByIdRodado(int idRodado) {
		List<PermisoPeriodoModel> aux = null;
		for (PermisoPeriodo p : permisoPeriodoRepository.FindByIdRodado(idRodado)) {
			aux.add(permisoPeriodoConverter.entityToModel(p));
		}
		return aux;
	}
}
