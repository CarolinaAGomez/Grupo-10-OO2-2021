package com.Grupo10OO22021.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;
import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.repository.IUsuarioRepository;


@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
    private IUsuarioRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username)    {
		com.Grupo10OO22021.entities.Usuario user =  userRepository.findByUsername(username);

	    //Mapear nuestra lista de Authority  de spring security 
	    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();  //se puede hacer tmb List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();???? ACA SOLO CREA UNA LISTA
	    
	     
	    //TRAE EL PERFIL DEL USUARIO QUE TRAJO POR EL USERNAME.
	    Perfil perfil= user.getPerfil();
	    
	    // Obtener una authority para autorizar/controlar un acceso. CLASE DE SPRINGBOOT
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getNombreRol());
        
        grantList.add(grantedAuthority); 
        
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo. NEW USER UNA CLASE DE USERDETAILS
        
	   
		UserDetails usuario = (UserDetails) new User (user.getUsername(), user.getPassword(), grantList);
	         return usuario;
		
	}
	
	

}
