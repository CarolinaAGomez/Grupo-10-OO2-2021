package com.Grupo10OO22021.controller;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.repository.IUsuarioRepository;
import com.Grupo10OO22021.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UsuarioController {
    
    @Autowired
	private IUsuarioRepository userRepo;

    @Autowired
    private IUsuarioService userService;

    @GetMapping("/")
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", userService.GetAll());
        return ViewRouteHelper.LISTAR;
    }

    @GetMapping("/alta")
    public ModelAndView altaUsuario(){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.ALTA);
        mav.addObject("usuario", new UsuarioModel());
        return mav;
    }
    @PostMapping("/crear")
    public RedirectView crearUsuario(@ModelAttribute("usuario") UsuarioModel usuario) throws Exception{
        userService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
    }

    @GetMapping("/update/{id}")
    public ModelAndView modifcarUsuario(@PathVariable("id") long id ){
        ModelAndView maV = new ModelAndView(ViewRouteHelper.MODIFICAR);
        maV.addObject("usuario", userService.traerUsuario(id));
        return maV;
    }
    @PostMapping("/actualizar")
    public RedirectView actualizarUsuario(@ModelAttribute ("usuario") UsuarioModel usuario  ) throws Exception{
        userService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
    }

    @PostMapping("/baja/{id}")
    public RedirectView eliminarUsuario(@PathVariable("id") int id ) throws Exception{
        userService.remove(id);
        return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
    }
}
