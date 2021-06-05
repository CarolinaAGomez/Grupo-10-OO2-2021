package com.Grupo10OO22021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.entities.Lugar;
import com.Grupo10OO22021.entities.PermisoPeriodo;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoPeriodoModel;

@Component("permisoPeriodoConverter")
public class PermisoPeriodoConverter {
		
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	
	public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {
		Set<LugarModel> desdeHasta = new HashSet<>();
		for(Lugar l : permisoPeriodo.getDesdeHasta()){
			desdeHasta.add(lugarConverter.entityToModel(l));
		}
		PermisoPeriodoModel permiso=null;
		if (permisoPeriodo!= null) {
			
	
			permiso= new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(),
										personaConverter.entityToModel(permisoPeriodo.getPedido()),
										permisoPeriodo.getFecha(),
										desdeHasta,
										permisoPeriodo.getCantDias(),
										permisoPeriodo.isVacaciones(),
										rodadoConverter.entityToModel(permisoPeriodo.getRodado())
										);
		
		}
		return permiso;
	}
		
	
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {
		Set<Lugar> desdeHasta = new HashSet<>();
		for(LugarModel l : permisoPeriodoModel.getDesdeHasta()){
			desdeHasta.add(lugarConverter.modelToEntity(l));
		}
		return new PermisoPeriodo(permisoPeriodoModel.getIdPermiso(),
									personaConverter.modelToEntity(permisoPeriodoModel.getPedido()),
									permisoPeriodoModel.getFecha(),
									desdeHasta,
									permisoPeriodoModel.getCantDias(),
									permisoPeriodoModel.isVacaciones(),
									rodadoConverter.modelToEntity(permisoPeriodoModel.getRodado())
									);
		
	}
	
	/*
	 * public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {
		Set<LugarModel> desdeHasta = new HashSet<>();
		for(Lugar l : permisoPeriodo.getDesdeHasta()){
			desdeHasta.add(lugarConverter.entityToModel(l));
		}
		
		return new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(),
										personaConverter.entityToModel(permisoPeriodo.getPedido()),
										permisoPeriodo.getFecha(),
										desdeHasta,
										permisoPeriodo.getCantDias(),
										permisoPeriodo.isVacaciones(),
										rodadoConverter.entityToModel(permisoPeriodo.getRodado())
										);
		
		}*/
	 
	

}
