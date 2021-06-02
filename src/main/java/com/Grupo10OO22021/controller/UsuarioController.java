package com.Grupo10OO22021.controller;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.services.IPerfilService;
import com.Grupo10OO22021.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;

    @Autowired
    @Qualifier("perfilService")
    private IPerfilService perfilService;
    

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("")
    public String listarUsuarios(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
        model.addAttribute("usuarios", usuarioService.GetAll());
        return ViewRouteHelper.USUARIO_LISTAR;
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("/alta")
    public ModelAndView altaUsuario( ){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.USUARIO_ALTA);

		
        mav.addObject("usuario", new UsuarioModel());
        mav.addObject("perfiles", perfilService.GetAll());
        return mav;
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @PostMapping("/crear")
    public RedirectView crearUsuario(  @ModelAttribute("usuario") @Validated  UsuarioModel usuario, BindingResult result, RedirectAttributes redirectAttrs) throws Exception{

		if (result.hasErrors()) {			 
			 System.out.println("entro a error");
			 return new RedirectView(ViewRouteHelper.USUARIO_LISTAR);
	    }
		
		if ((usuarioService.traerUsuarioPorDni(usuario.getDni()) != null)) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Ya existe un usuario con ese dni")
	                .addFlashAttribute("clase", "warning");
	        return new RedirectView(ViewRouteHelper.USUARIO_PRUEBA); //VER ESTO CON SEBA PORQUE SI PONGO ALTA ME LLEVA A UN PATH QUE NO EXISTE
	        
	    }
		
		if (usuarioService.traerUsuarioPorUsername(usuario.getUsername())!=null) {
	        redirectAttrs
	                .addFlashAttribute("muser", "Ya existe un usuario con ese username")
	                .addFlashAttribute("username", "warning");
	        return new RedirectView(ViewRouteHelper.USUARIO_PRUEBA);
	        
	    }
		
		
        usuarioService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @GetMapping("/update/{id}")
    public ModelAndView modifcarUsuario(@PathVariable("id") long id ){
        ModelAndView mav = new ModelAndView(ViewRouteHelper.USUARIO_MODIFICAR);
        UsuarioModel userModel =  usuarioService.traerUsuarioYPerfilPorId(id);
        mav.addObject("usuario", userModel);
        mav.addObject("perfiles", perfilService.GetAll());
        return mav;
    }

    @PreAuthorize("hasRol('ROLE_ADMIN')")
    @PostMapping("/baja/{id}")
    public RedirectView eliminarUsuario(@PathVariable("id") int id ) throws Exception{
        usuarioService.remove(id);
        return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
    }
    
    
   
    
}



