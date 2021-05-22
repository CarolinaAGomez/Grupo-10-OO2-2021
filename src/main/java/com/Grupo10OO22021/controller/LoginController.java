package com.Grupo10OO22021.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.services.impl.UsuarioService;



@Controller
public class LoginController {
	
	
	@Autowired
	private UsuarioService userService;
	
	
	@GetMapping("/")
	public String Login(){
		return ViewRouteHelper.LOGIN;
	}

	
	@GetMapping("/login")
	public String toLogin(){
		return ViewRouteHelper.LOGIN;
	}

	@GetMapping("/menu")
	public String /*RedirectView */ index(Authentication auth, HttpSession session, Model model) {
		//RedirectView rv = null;
		String rv=null;;
		//Para conseguir el nombre del usuario de la sesion, ya estoy adentro(?
		String username= auth.getName();  //USERNAME
		//Si el usuario no esta creado aun
		if (session.getAttribute("usuario")== null) {
			//Lo voy a buscar a la BD
			UsuarioModel usuario = userService.traerUsuarioPorUsername(username);
			System.out.println(usuario);
			//La clave es null porque no la necesito. No lo manda.
			usuario.setPassword(null);
			//vamos a mandar a la vista el usuario.
			session.setAttribute("usuario", usuario); //Se lo mando a la vista
			
			if(usuario.getPerfil().getNombreRol().equals("ROLE_USER")) {
				System.out.println(usuario.getPerfil().getNombreRol());
				//rv = new RedirectView(ViewRouteHelper.MENU_USER);
				rv = ViewRouteHelper.MENU_USER;
				
			}
			if(usuario.getPerfil().getNombreRol().equals("ROLE_AUDITOR")) {
				System.out.println(usuario.getPerfil().getNombreRol());
				//rv= new RedirectView (ViewRouteHelper.MENU_AUDITOR);
				rv = ViewRouteHelper.MENU_AUDITOR;
			}
			
			if(usuario.getPerfil().getNombreRol().equals("ROLE_ADMIN")) {
				System.out.println(usuario.getPerfil().getNombreRol());
				//rv = new RedirectView(ViewRouteHelper.MENU_ADMIN);
				rv = ViewRouteHelper.MENU_ADMIN;
				
			}
			
		}
		return rv;

	}

}
