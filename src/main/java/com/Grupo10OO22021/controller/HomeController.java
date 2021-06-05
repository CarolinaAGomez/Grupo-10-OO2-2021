package com.Grupo10OO22021.controller;


import com.Grupo10OO22021.helpers.ViewRouteHelper;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public ModelAndView toHome(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME);  
        return mV;
    }
}
