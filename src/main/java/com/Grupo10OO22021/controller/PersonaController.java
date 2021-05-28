package com.Grupo10OO22021.controller;

import java.lang.ProcessBuilder.Redirect;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PersonaModel;
import com.Grupo10OO22021.services.IPersonaService;
import com.Grupo10OO22021.services.impl.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
    public RedirectView create(@ModelAttribute("persona") PersonaModel personaModel) {
        personaService.insertOrUpdate(personaModel);
        return new RedirectView(ViewRouteHelper.HOME_ROOT);
    }
}
