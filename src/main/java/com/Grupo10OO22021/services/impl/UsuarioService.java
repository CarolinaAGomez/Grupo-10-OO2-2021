package com.Grupo10OO22021.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Grupo10OO22021.converters.UsuarioConverter;
import com.Grupo10OO22021.entities.Usuario;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.repository.IUsuarioRepository;
import com.Grupo10OO22021.services.IUsuarioService;


@Service
public class UsuarioService implements IUsuarioService {

	@Autowired //Inyeccion de dependencia-- Patron Singleton
	private IUsuarioRepository userRepo;
	
	@Autowired
	private UsuarioConverter userConverter;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	
	@Override
	public List<Usuario> GetAll() {
		
		return userRepo.findAll();
	}

	@Override
	public UsuarioModel traerUsuario(long id) {
		
		//COMO EL REPO TRABAJA CON ENTIDAD HAY QUE PASARLO A MODEL PORQUE LA INTERFACE SERVICE TRABAJA CON MODEL
		UsuarioModel usuario= userConverter.entityToModel(userRepo.findByIdUsuario(id));
		return usuario;
	}

	@Override
	public UsuarioModel traerUsuario(int dni) {
		UsuarioModel usuario = userConverter.entityToModel(userRepo.findByDni(dni));
		return usuario;
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuario){
		//SETEA LA CLAVE PARA QUE SE ENCRIPTE
		usuario.setPassword(passwordEnconder.encode(usuario.getPassword()));
		//convierte el modelo en entidad y guarda el entity que se convirtio anteriormente. 
		Usuario user= userRepo.save(userConverter.modelToEntity(usuario));
		//convierte nuevamente en modelo para retonarlo
		return userConverter.entityToModel(user);
	}

	@Override
	public boolean remove(long idUsuario) {
		try {
		userRepo.deleteById(idUsuario);
		return true;
		}catch( Exception he){
			return false;
		}
		
		
	}

}
