package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.RodadoModel;
import com.Grupo10OO22021.services.impl.RodadoService;

@Controller
@RequestMapping("/rodado")
public class RodadoController {

	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;
	
	@GetMapping("")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.RODADO_NEW);
		mV.addObject("rodado" , new RodadoModel());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("rodado")  @Validated RodadoModel rodadoModel, BindingResult result, RedirectAttributes redirectAttrs) {
		rodadoModel.setDominio(rodadoModel.getDominio().toLowerCase());
		for(RodadoModel r : rodadoService.getAll()) {
			if ((r.getDominio().equals(rodadoModel.getDominio()))) {
		        redirectAttrs
		                .addFlashAttribute("mensaje", "Ya existe el dominio, ingreso otro dominio")
		                .addFlashAttribute("clase", "warning");
		        return new RedirectView(ViewRouteHelper.RODADO_PRUEBA); //VER ESTO CON SEBA PORQUE SI PONGO ALTA ME LLEVA A UN PATH QUE NO EXISTE
		        
		    }
		}
		
		
		rodadoService.inserOrUpdate(rodadoModel);
		return new RedirectView(ViewRouteHelper.RODADO_ROOT);
	}
}

