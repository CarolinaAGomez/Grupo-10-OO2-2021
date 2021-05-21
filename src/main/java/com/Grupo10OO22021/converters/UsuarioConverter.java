package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Usuario;
import com.Grupo10OO22021.models.UsuarioModel;



@Component
public class UsuarioConverter {
	
	
	public UsuarioModel entityToModel(Usuario user) {
		UsuarioModel userModel = null;
		if(user != null){
			userModel = new UsuarioModel(user.getIdUsuario(),
										 user.getNombre(), 
										 user.getApellido(), 
										 user.getDni(), 
										 user.getMail(), 
										 user.getUsername(), 
										 user.getPassword()
			);
		}
		return userModel;
	}
	
	
	public Usuario modelToEntity(UsuarioModel userModel) {
		return new Usuario(userModel.getIdUsuario(),
						   userModel.getNombre(), 
						   userModel.getApellido(),
						   userModel.getDni(), 
						   userModel.getMail(), 
						   userModel.getUsername(), 
						   userModel.getPassword()
		);
	}
	

}
