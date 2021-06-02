package com.Grupo10OO22021.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.PermisoConverter;
import com.Grupo10OO22021.converters.PermisoDiarioConverter;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.models.PermisoModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.repository.IPermisoRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPermisoService;

@Service("permisoService")
public class PermisoService  implements IPermisoService{
	
	
	@Autowired
    private PermisoConverter permisoConverter;
	
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	
	@Override
	public PermisoModel insertOrUpdate(PermisoModel permiso) {
		
		
		
		return permisoConverter.entityToModel(permisoRepository.save(permisoConverter.modelToEntity(permiso)));
	}


	@Override
	public PermisoModel traerPermisoxPersona(int idPersona) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
