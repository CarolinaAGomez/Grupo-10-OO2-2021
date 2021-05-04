package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.entities.Usuario;
import com.Grupo10OO22021.models.UsuarioModel;

public interface IUsuarioService {
	
	
	//LA INTERFACE SERVICE TRABAJA CON EL MODEL
	
	public List<Usuario> GetAll();
	
	public UsuarioModel traerUsuario(long id);
	
	public UsuarioModel traerUsuario(int dni);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuario) throws Exception;
	
	public boolean remove (long idUsuario);
	
	
	

}
