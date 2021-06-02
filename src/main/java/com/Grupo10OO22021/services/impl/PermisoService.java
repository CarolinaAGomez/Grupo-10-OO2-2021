package com.Grupo10OO22021.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.PermisoConverter;
import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.entities.Persona;
import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.repository.IPermisoRepository;
import com.Grupo10OO22021.services.IPermisoService;

@Service("permisoService")
public class PermisoService  implements IPermisoService{
	
	@Autowired
	@Qualifier("permisoConverter")
    private PermisoConverter permisoConverter;
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Override
	public PermisoModel insertOrUpdate(PermisoModel permiso) {
		return permisoConverter.entityToModel(permisoRepository.save(permisoConverter.modelToEntity(permiso)));
	}

	@Override
	public Set<PermisoModel> traerPermisoxPersona(int idPersona) {
		Set<PermisoModel> aux = new HashSet<>();
		for (Permiso p : permisoRepository.findByPedido(idPersona)) {
			aux.add(permisoConverter.entityToModel(p));
		}
		return aux;
	}
}
