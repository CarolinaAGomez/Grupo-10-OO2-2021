package com.Grupo10OO22021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.Set;

import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoPeriodoModel;
import com.Grupo10OO22021.services.ILugarService;
import com.Grupo10OO22021.services.IPermisoPeriodoService;
import com.Grupo10OO22021.services.impl.PersonaService;
import com.Grupo10OO22021.services.impl.RodadoService;

@Controller
@RequestMapping("/permisoperiodo")
public class PermisoPeriodoController {

	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;

	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;

	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;

	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;

	@GetMapping("")
	public ModelAndView altaPermisoPeriodo() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISOPERIODO_NEW);
		mV.addObject("permiso", new PermisoPeriodoModel());
		mV.addObject("personas", personaService.GetAll());
		mV.addObject("rodados", rodadoService.getAll());
		mV.addObject("lugares", lugarService.getAll());
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("permiso") PermisoPeriodoModel permiso,
			@RequestParam(required = true) int desde, @RequestParam(required = true) int hasta) {
		Set<LugarModel> lugares = new HashSet<>();
		LugarModel desdeLugar = lugarService.findByIdLugar(desde);
		LugarModel hastaLugar = lugarService.findByIdLugar(hasta);
		lugares.add(desdeLugar);
		lugares.add(hastaLugar);
		permiso.setDesdeHasta(lugares);
		permisoPeriodoService.insertOrUpdate(permiso);
		return new RedirectView(ViewRouteHelper.HOME_ROOT);
	}

}
