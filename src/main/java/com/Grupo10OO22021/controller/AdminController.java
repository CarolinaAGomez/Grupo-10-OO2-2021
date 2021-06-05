package com.Grupo10OO22021.controller;

import com.Grupo10OO22021.helpers.ViewRouteHelper;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("")
    public ModelAndView menu(){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.MENU_ADMIN);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();            
		mav.addObject("user", user);
        return mav;
    }
}
