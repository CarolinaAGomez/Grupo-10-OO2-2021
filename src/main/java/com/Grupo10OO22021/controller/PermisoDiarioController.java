package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.services.impl.LugarService;
import com.Grupo10OO22021.services.impl.PermisoService;
import com.Grupo10OO22021.services.impl.PersonaService;

@Controller
@RequestMapping("/permisodiario")
public class PermisoDiarioController {

	@Autowired
	private PermisoService permisoService;

	@Autowired
	private PersonaService personaService;

	@Autowired
	private IPermisoDiarioRepository permisodRepository;

	@Autowired
	private LugarService lugarService;

	@GetMapping("")
	public ModelAndView altaPermiso() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISODIARIO_NEW);
		// mV.addObject("permiso", new PermisoModel());SI PONGO ESTE NO TRAE MOTIVO
		mV.addObject("permiso", new PermisoDiarioModel());
		mV.addObject("personas", personaService.GetAll());
		mV.addObject("lugares", lugarService.getAll()); // sin esto no trae
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(/* @ModelAttribute("permisoModel") PARA QUE ES ESTO? */PermisoDiario permisoModel) {

		permisodRepository.save(permisoModel);
		// permisoService.insertOrUpdate(permisoModel); CON SERVICE NO ME ANDA. Sera el
		// converter?
		return new RedirectView(ViewRouteHelper.HOME_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISODIARIO_MOSTRAR);
		mAV.addObject("person", permisoService.traerPermisoxPersona(id));
		return mAV;
	}
}
