package com.Grupo10OO22021.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22021.entities.Usuario;
import com.Grupo10OO22021.repository.IUsuarioRepository;
import com.Grupo10OO22021.services.impl.UsuarioService;

@Controller
public class LoginController {
	
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private IUsuarioRepository userRepo;

	@GetMapping("/menu")
	public ModelAndView index(Authentication auth, HttpSession session, Model model) {
		ModelAndView mv = null;
		//Para conseguir el nombre del usuario de la sesion, ya estoy adentro(?
		String username= auth.getName();  //USERNAME
		
		//Si el usuario no esta creado aun
		if (session.getAttribute("usuario")== null) {
			//Lo voy a buscar a la BD
			Usuario usuario = userRepo.findByUsername(username);
			//La clave es null porque no la necesito. No lo manda.
			usuario.setPassword(null);
			//vamos a mandar a la vista el usuario.
			session.setAttribute("usuario", usuario); //Se lo mando a la vista
			
			if(usuario.getPerfil().getIdPerfil()==1) {
				 mv=new ModelAndView("menuuser");
			}
			if(usuario.getPerfil().getIdPerfil()==2) {
				 mv=new ModelAndView("menu");
			}
		}
		return mv;
	}
	

}
