package com.Grupo10OO22021.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.services.impl.UsuarioService;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
		
	@GetMapping("")
	public String toLogin(){
		return ViewRouteHelper.LOGIN;
	}

	@GetMapping("/redirectMenu")
	public RedirectView index(Authentication auth, HttpSession session, Model model) {
		RedirectView rv= null;
		String username= auth.getName(); 
		System.out.println(username);
		if (session.getAttribute("usuario")== null) {
			UsuarioModel usuario = usuarioService.traerUsuarioPorUsername(username);;
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
			
			if(usuario.getPerfil().getNombreRol().equals("ROLE_USER")) {
				rv = new RedirectView(ViewRouteHelper.MENU_USER);
			}
			if(usuario.getPerfil().getNombreRol().equals("ROLE_AUDITOR")) {
				rv = new RedirectView(ViewRouteHelper.AUDITOR_ROOT);
			}
			if(usuario.getPerfil().getNombreRol().equals("ROLE_ADMIN")) {
				rv = new RedirectView(ViewRouteHelper.ADMIN_ROOT);
			}
		}
		return rv;
	}

}