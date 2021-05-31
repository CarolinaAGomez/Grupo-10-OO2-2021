package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.Grupo10OO22021.entities.PermisoPeriodo;
import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PermisoPeriodoModel;
import com.Grupo10OO22021.repository.IPermisoPeriodoRepository;
import com.Grupo10OO22021.services.impl.PersonaService;
import com.Grupo10OO22021.services.impl.RodadoService;


@Controller
@RequestMapping("/permisoperiodo")
public class PermisoPeriodoController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private RodadoService rodadoService;
	
	@Autowired
	private IPermisoPeriodoRepository permisoperiodoRepository;
	
	@PreAuthorize("hasRol('ROLE_AUDITOR')")
	@GetMapping("")
    public ModelAndView altaPermisoPeriodo(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISOPERIODO_NEW);
		mV.addObject("permiso", new PermisoPeriodoModel());
		mV.addObject("personas", personaService.GetAll());
		mV.addObject("rodados",rodadoService.getAll()); 
		return mV;
    }

    @PostMapping("/create")
    public RedirectView create(/*@ModelAttribute("permisoModel") PARA QUE ES ESTO? */PermisoPeriodo permisoModel) {
    
    	permisoperiodoRepository.save(permisoModel);
    	//permisoService.insertOrUpdate(permisoModel); CON SERVICE NO ME ANDA. Sera el converter?
        return new RedirectView(ViewRouteHelper.HOME_ROOT);
    }
    
	
	
	
	
	

}
