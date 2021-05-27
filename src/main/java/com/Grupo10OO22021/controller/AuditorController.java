package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/auditor")
public class AuditorController {
	
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@PreAuthorize("hasRol('ROLE_AUDITOR')")
	@GetMapping("")
	public ModelAndView menu(){
		ModelAndView mav = new ModelAndView(ViewRouteHelper.MENU_AUDITOR);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", user);
		return mav;
	}

	@PreAuthorize("hasRol('ROLE_AUDITOR')")
	@GetMapping("/listarAdmins")
	public String listarUsuariosAdministradores(Model model){
		List<UsuarioModel> admins = usuarioService.traerUsuariosPorRol("ROLE_ADMIN");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		model.addAttribute("usuarios", admins);
		return ViewRouteHelper.AUDITOR_LISTAR;
	}
	
	@PreAuthorize("hasRol('ROLE_AUDITOR')")
	@GetMapping("/listarAuditores")
	public String listarUsuariosAuditores(Model model){
		List<UsuarioModel> auditores = usuarioService.traerUsuariosPorRol("ROLE_AUDITOR");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		model.addAttribute("usuarios", auditores);
		return ViewRouteHelper.AUDITOR_LISTAR;
	}

}
