package com.Grupo10OO22021.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.UsuarioConverter;
import com.Grupo10OO22021.entities.Usuario;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.repository.IUsuarioRepository;
import com.Grupo10OO22021.services.IUsuarioService;


@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	@Autowired 
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	
	@Override
	public List<UsuarioModel> GetAll() {
		List<UsuarioModel> usuarios = new ArrayList<>();
		for(Usuario u : usuarioRepository.findAll()){
			usuarios.add(usuarioConverter.entityToModel(u));
		}
		return usuarios;
	}

	public List<UsuarioModel> traerUsuariosPorRol(String nombreRol){
		List<UsuarioModel> usuarios = new ArrayList<>();
		for(UsuarioModel u : GetAll()){
			if(u.getPerfil().getNombreRol().equals(nombreRol)){
				usuarios.add(u);
			}
		}
		return usuarios;
	}
	@Override
	public UsuarioModel traerUsuarioPorId(long id) {
		
		//COMO EL REPO TRABAJA CON ENTIDAD HAY QUE PASARLO A MODEL PORQUE LA INTERFACE SERVICE TRABAJA CON MODEL
		UsuarioModel usuario= usuarioConverter.entityToModel(usuarioRepository.findByIdUsuario(id));
		return usuario;
	}

	@Override
	public UsuarioModel traerUsuarioYPerfilPorId(long id){
		UsuarioModel usuario = usuarioConverter.entityToModel(usuarioRepository.findByIdUsuarioAndFetchPerfilEagerly(id));
		return usuario ;
	}

	@Override
	public UsuarioModel traerUsuarioYPerfilPorUsername(String username){
		UsuarioModel usuario = usuarioConverter.entityToModel(usuarioRepository.findByUsernameAndFetchPerfilEagerly(username));
		return usuario;
	}
	@Override
	public UsuarioModel traerUsuarioPorUsername(String username){
		UsuarioModel usuario = usuarioConverter.entityToModel(usuarioRepository.findByUsername(username));
		return usuario;
	}
	@Override
	public UsuarioModel traerUsuarioPorDni(int dni) {
		UsuarioModel usuario = usuarioConverter.entityToModel(usuarioRepository.findByDni(dni));
		return usuario;
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuario){
        if(usuario.getPassword().equals("")){
            usuario.setPassword(traerUsuarioPorId(usuario.getIdUsuario()).getPassword());
        }
        else{
			usuario.setPassword(passwordEnconder.encode(usuario.getPassword()));
		}
		Usuario user= usuarioRepository.save(usuarioConverter.modelToEntity(usuario));
		return usuarioConverter.entityToModel(user);
	}

	@Override
	public boolean remove(long idUsuario) {
		try {
		usuarioRepository.deleteById(idUsuario);
		return true;
		}catch( Exception he){
			return false;
		}
		
		
	}

}
