package com.Grupo10OO22021.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22021.converters.PermisoConverter;
import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.repository.IPermisoRepository;
import com.Grupo10OO22021.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;

	@Override
	public List<PermisoModel> findAll() {

		List<PermisoModel> listPermiso = new ArrayList();
		for (Permiso p : permisoRepository.findAll()) {
			listPermiso.add(permisoConverter.entityToModel(p));
		}

		return listPermiso;
	}

	@Override
	public PermisoModel insertOrUpdate(PermisoModel permiso) {

		return permisoConverter.entityToModel(permisoRepository.save(permisoConverter.modelToEntity(permiso)));
	}

	@Override
	public PermisoModel findByPedido(int idPersona) {
		// TODO Auto-generated method stub
		
			return permisoConverter.entityToModel(permisoRepository.findByPedido(idPersona));
	}

	

}
