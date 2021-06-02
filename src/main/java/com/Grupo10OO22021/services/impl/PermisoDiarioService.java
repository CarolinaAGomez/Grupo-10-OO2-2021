package com.Grupo10OO22021.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22021.converters.PermisoDiarioConverter;
import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;

@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService {

	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;

	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;

	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso) {
		return permisoDiarioConverter.entityToModel(permisoDiarioRepository
			.save(permisoDiarioConverter.modelToEntity(permiso)));
	}

	@Override
	public Set<PermisoDiarioModel> findByPedido(int idPersona) {
		Set<PermisoDiarioModel> aux = new HashSet<>();
		for (PermisoDiario p : permisoDiarioRepository.findByPedido(idPersona)) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}
}
