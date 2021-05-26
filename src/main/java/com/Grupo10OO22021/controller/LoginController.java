
package com.Grupo10OO22021.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> 8f0b9ab024f9cf5705edca64b62009160ad38d04
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
	private UsuarioService userService;

	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	
	@GetMapping("")
	public String toLogin(){
		return ViewRouteHelper.LOGIN;
	}

	@GetMapping("/redirectMenu")
	public RedirectView index(Authentication auth, HttpSession session, Model model) {

		//RedirectView rv = null;
		RedirectView rv=null;
		//Para conseguir el nombre del usuario de la sesion, ya estoy adentro(?
		String username= auth.getName();  //USERNAME
		System.out.println(username);
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
				rv = new RedirectView(ViewRouteHelper.MENU_USER);
				
			}
			if(usuario.getPerfil().getNombreRol().equals("ROLE_AUDITOR")) {
				System.out.println(usuario.getPerfil().getNombreRol());
				//rv= new RedirectView (ViewRouteHelper.MENU_AUDITOR);
				rv = new RedirectView(ViewRouteHelper.AUDITOR_ROOT);
			}
			
			if(usuario.getPerfil().getNombreRol().equals("ROLE_ADMIN")) {
				System.out.println(usuario.getPerfil().getNombreRol());
				//rv = new RedirectView(ViewRouteHelper.MENU_ADMIN);
				rv = new RedirectView(ViewRouteHelper.ADMIN_ROOT);
				
			}
			
		}
		return rv;


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