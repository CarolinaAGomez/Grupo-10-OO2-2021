package com.Grupo10OO22021.controller;

import com.Grupo10OO22021.helpers.ViewRouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

    @GetMapping("")
    public ModelAndView menu(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER);
        return mV;
    }

    @GetMapping("/traerPorPersona")
    public ModelAndView traerPorPersona(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_POR_PERSONA);
        return mV;
    }
}