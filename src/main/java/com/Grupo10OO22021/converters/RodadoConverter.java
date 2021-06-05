package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Rodado;
import com.Grupo10OO22021.models.RodadoModel;
import com.Grupo10OO22021.models.UsuarioModel;

@Component("rodadoConverter")
public class RodadoConverter {
	
	
	public RodadoModel entityToModel(Rodado rodado) {
		RodadoModel rodadoModel = null;
		if(rodado != null){
		
			rodadoModel =new RodadoModel(rodado.getIdRodado(), rodado.getDominio(), rodado.getVehiculo());
	}
		return rodadoModel;
	}
	
	public Rodado modelToEntity(RodadoModel rodadomodel) {
		
		Rodado rodado = null;
		if(rodadomodel != null){
		
			rodado= new Rodado(rodadomodel.getIdRodado(), rodadomodel.getDominio(), rodadomodel.getVehiculo());
	}
		return rodado;
	}
}
