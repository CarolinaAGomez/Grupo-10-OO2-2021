package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PerfilModel;
import com.Grupo10OO22021.services.impl.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired()
	private PerfilService perfilService;
	
	@GetMapping("")
	public ModelAndView vista() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_INDEX);
		mV.addObject("perfil" ,perfilService.GetAll());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_NEW);
		mV.addObject("perfil", new PerfilModel());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		perfilService.remove(id);
		System.out.println(id);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView updateGet(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERFIL_UPDATE);
		mV.addObject("perfil" ,perfilService.findById(id));
		return mV;
	}
	
	@PostMapping("/updatePost")
	public RedirectView updatePost(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_ROOT);
	}
}


/*
 * 
 * 
	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("person", personService.findByName(name));
		return mAV;
	}
	
 * 
 * @PostMapping("/update")
	public RedirectView update(@ModelAttribute("person") PersonModel personModel) {
		personService.insertOrUpdate(personModel);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}*/
