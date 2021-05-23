package com.Grupo10OO22021.controller;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.services.IPerfilService;
import com.Grupo10OO22021.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/usuario")
public class AdminController {

    @Autowired
    private IUsuarioService userService;

    @Autowired
    private IPerfilService perfilService;

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("")
    public ModelAndView menu(){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.MENU_ADMIN);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", user);
        return mav;
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
        model.addAttribute("usuarios", userService.GetAll());
        return ViewRouteHelper.ADMIN_LISTAR;
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("/alta")
    public ModelAndView altaUsuario(){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.ADMIN_ALTA);
        mav.addObject("usuario", new UsuarioModel());
        mav.addObject("perfiles", perfilService.GetAll());
        return mav;
    }

    @PostMapping("/crear")
    public RedirectView crearUsuario(@ModelAttribute("usuario") UsuarioModel usuario) throws Exception{
        userService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("/update/{id}")
    public ModelAndView modifcarUsuario(@PathVariable("id") long id ){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.ADMIN_MODIFICAR);
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorId(id);
        mav.addObject("usuario", userModel);
        mav.addObject("perfiles", perfilService.GetAll());
        return mav;
    }

    @PostMapping("/actualizar")
    public RedirectView actualizarUsuario(@ModelAttribute ("usuario") UsuarioModel usuario  ) throws Exception{
        userService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
    }

    @PostMapping("/baja/{id}")
    public RedirectView eliminarUsuario(@PathVariable("id") int id ) throws Exception{
        userService.remove(id);
        return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
    }
}
