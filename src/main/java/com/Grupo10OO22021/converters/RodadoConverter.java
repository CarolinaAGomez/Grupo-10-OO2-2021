package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Rodado;
import com.Grupo10OO22021.models.RodadoModel;

@Component
public class RodadoConverter {
	
	
	public RodadoModel modelToEntity(Rodado rodado) {
		
		return new RodadoModel(rodado.getIdRodado(), rodado.getDominio(), rodado.getVehiculo());
	}
	
	public Rodado entityToModel(RodadoModel rodadomodel) {
		
		return new Rodado(rodadomodel.getIdRodado(), rodadomodel.getDominio(), rodadomodel.getVehiculo());
	}
	
	

}
