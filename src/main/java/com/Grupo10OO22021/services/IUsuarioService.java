package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.models.UsuarioModel;

public interface IUsuarioService {
		
	public List<UsuarioModel> GetAll();

	public List<UsuarioModel> traerUsuariosPorRol(String nombreRol);
	
	public UsuarioModel traerUsuarioPorId(long id);

	public UsuarioModel traerUsuarioYPerfilPorId(long id);
	
	//borrarr
	public UsuarioModel traerUsuarioYPerfilPorIdperfil(int id);

	public UsuarioModel traerUsuarioYPerfilPorUsername(String username);
	
	public UsuarioModel traerUsuarioPorUsername(String username);
	
	public UsuarioModel traerUsuarioPorDni(int dni);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuario) throws Exception;
	
	public boolean remove (long idUsuario);
	
}
