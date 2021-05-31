package com.Grupo10OO22021.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.Grupo10OO22021.converters.PermisoDiarioConverter;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;


@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService {
	
	@Autowired
    private PermisoDiarioConverter permisoDiarioConverter;
	
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;
	
	
	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso) {
		
	return permisoDiarioConverter.entityToModel(permisoDiarioRepository.save(permisoDiarioConverter.modelToEntity(permiso)));
	}
	
	/*
	public void agregarLugaraPermiso(Permiso permiso) {
		System.out.println("entro a permisoooooo diarioooo");
		for(Lugar l : permiso.getDesdeHasta()) {
		
		permiso.agregarLugaraPermiso(l);
		 System.out.println("ENTROO"+l);
		}
	}
	*/

	

	

}
