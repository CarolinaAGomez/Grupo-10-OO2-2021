package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPermisoPeriodoService;
import com.Grupo10OO22021.services.IPermisoService;
import com.Grupo10OO22021.services.IPersonaService;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;
	
    @GetMapping("/traer")
    public ModelAndView menu(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER);
        return mV;
    }

   @GetMapping("/vistaPorPersona")
   public ModelAndView vista() {
	   ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_POR_PERSONA);
	   mV.addObject("personas",personaService.GetAll());
	   return mV;
   }
   
   @PostMapping("/traerPorPersona")
    public ModelAndView traerPorPersona(@RequestParam(required = true) int idPersona){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);
        mV.addObject("permiso_diario",permisoDiarioService.findByPedido(idPersona));
        mV.addObject("permiso_periodo",permisoPeriodoService.findByPedido(idPersona));
        return mV;
    }
}