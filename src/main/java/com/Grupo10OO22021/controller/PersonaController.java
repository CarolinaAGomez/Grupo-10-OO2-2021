package com.Grupo10OO22021.controller;


import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PersonaModel;
import com.Grupo10OO22021.services.IPersonaService;
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


@Controller
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    @Qualifier("personaService")
    private IPersonaService personaService;
    
    @GetMapping("")
    public ModelAndView altaPersona(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERSONA_NEW);
		mV.addObject("persona", new PersonaModel());
		 
		return mV;
    }

    @PostMapping("/insert")
    public RedirectView create(@ModelAttribute("persona") @Validated PersonaModel personaModel, BindingResult result, RedirectAttributes redirectAttrs ) {
       
    	if (personaService.traerDniPersona(personaModel.getDni())!=null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Ya existe un usuario con ese dni")
	                .addFlashAttribute("clase", "warning");
	       
	        return new RedirectView(ViewRouteHelper.PERSONA_PRUEBA); //VER ESTO CON SEBA PORQUE SI PONGO ALTA ME LLEVA A UN PATH QUE NO EXISTE
	        
	    }
        personaService.insertOrUpdate(personaModel);
        return new RedirectView(ViewRouteHelper.HOME_ROOT);
      
      
    }
}
