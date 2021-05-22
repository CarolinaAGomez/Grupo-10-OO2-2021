package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/auditor")
public class AuditorController {
	
	
	  @Autowired
	    private IUsuarioService userService;
	
	  @GetMapping("/")
	    public String listarUsuarios(Model model){
	        model.addAttribute("usuarios", userService.GetAll());
	        return ViewRouteHelper.LISTADO;
	    }

}
