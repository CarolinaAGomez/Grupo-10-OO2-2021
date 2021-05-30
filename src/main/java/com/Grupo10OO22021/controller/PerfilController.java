package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PerfilModel;
import com.Grupo10OO22021.services.IUsuarioService;
import com.Grupo10OO22021.services.impl.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
	
	@Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;
	
	
	
	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@GetMapping("")
	public ModelAndView vista() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mV.addObject("user", user);
		mV.addObject("perfil" ,perfilService.GetAll());
		return mV;
	}
	
	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_NEW);
		mV.addObject("perfil", new PerfilModel());
		return mV;
	}
	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}

	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id,@Validated Perfil perfil, BindingResult result,RedirectAttributes redirectAttrs) {
		if (usuarioService.traerUsuarioYPerfilPorId(id)!=null) {
			
			System.out.println(usuarioService.traerUsuarioYPerfilPorId(id));
	        redirectAttrs
	                .addFlashAttribute("muser", "NO SE PUEDE BORRAR EL PERFIL YA QUE TIENE UN USUARIO ASOCIADO")
	                .addFlashAttribute("username", "warning");
	        return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	        
	    }
		
		
		perfilService.remove(id);
		System.out.println(id);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}
	
	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@GetMapping("/update/{id}")
	public ModelAndView updateGet(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_UPDATE);
		mV.addObject("perfil" ,perfilService.findById(id));
		return mV;
	}
	
	@PreAuthorize("hasRol('ROLE_ADMIN')")
	@PostMapping("/updatePost")
	public RedirectView updatePost(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}
}