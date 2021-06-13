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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.models.RodadoModel;
import com.Grupo10OO22021.services.ILugarService;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPersonaService;

@Controller
@RequestMapping("/permisodiario")
public class PermisoDiarioController {
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	

	
	@GetMapping("")
    public ModelAndView altaPermiso(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISODIARIO_NEW);
		
		mV.addObject("permiso", new PermisoDiarioModel());
		mV.addObject("desde", new LugarModel()); 
		mV.addObject("hasta", new LugarModel()); 
		mV.addObject("personas", personaService.GetAll());
		mV.addObject("lugares",lugarService.getAll()); //sin esto no trae
		return mV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("permiso") @Validated PermisoDiarioModel permiso, BindingResult result,RedirectAttributes redirectAttrs,
							   @RequestParam(required = true) int desde,
							   @RequestParam(required = true) int hasta) {
    	if (result.hasErrors()) {			 
			 redirectAttrs
            .addFlashAttribute("mensaje", "La fecha tiene que ser desde hoy")
            .addFlashAttribute("clase", "warning");
    return new RedirectView("/permisodiario"); 
    
	    }
    	
    	
		Set<LugarModel> lugares = new HashSet<>();
		LugarModel desdeLugar = lugarService.findByIdLugar(desde);
		LugarModel hastaLugar = lugarService.findByIdLugar(hasta);
		lugares.add(desdeLugar);
		lugares.add(hastaLugar);
		permiso.setDesdeHasta(lugares);
    	permisoDiarioService.insertOrUpdate(permiso);
        return new RedirectView(ViewRouteHelper.HOME_ROOT);
    }
}