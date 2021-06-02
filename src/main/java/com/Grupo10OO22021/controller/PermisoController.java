package com.Grupo10OO22021.controller;


import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.services.ILugarService;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPermisoPeriodoService;
import com.Grupo10OO22021.services.IRodadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

    @Autowired
    @Qualifier("rodadoService")
    public IRodadoService rodadoService;

    @Autowired
    @Qualifier("permisoPeriodoService")
    public IPermisoPeriodoService permisoPeriodoService;

    @Autowired
    @Qualifier("permisoDiarioService")
    public IPermisoDiarioService permisoDiarioService;

    @Autowired
    @Qualifier("lugarService")
    public ILugarService lugarService;

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

    @PreAuthorize("hasRol('ROLE_AUDITOR')")
    @GetMapping("/traerPorRodado")
    public ModelAndView traerPorRodado(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_POR_RODADO);
        mV.addObject("rodados", rodadoService.getAll());
        return mV;
    }
    
    @PreAuthorize("hasRol('ROLE_AUDITOR')")
    @PostMapping("/traerPorRodado")
    public ModelAndView traerPermisoPorRodado(@RequestParam(required = true) int rodado){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_POR_RODADO);
        mV.addObject("rodados", rodadoService.getAll());
        System.out.println(permisoPeriodoService.traerPermisoxRodado(rodado));
        mV.addObject("permisosPeriodo",permisoPeriodoService.traerPermisoxRodado(rodado));
        return mV;
    }


    @PreAuthorize("hasRol('ROLE_AUDITOR')")
    @GetMapping("/traerActivos")
    public ModelAndView traerPermisoPorRodado(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_ACTIVOS);
        mV.addObject("lugares", lugarService.getAll());
        return mV;
    }
    @PreAuthorize("hasRol('ROLE_AUDITOR')")
    @PostMapping("/traerActivos")
    public ModelAndView traerPermisosActivos(@RequestParam(required = true) String fechaInicial, @RequestParam(required = true) String fechaFinal,
                                            @RequestParam(required = true) int desde, @RequestParam(required = true) int hasta){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_TRAER_ACTIVOS);
        mV.addObject("lugares", lugarService.getAll());
        // mV.addObject("fechaInicial", fechaInicial);
        // mV.addObject("fechaFinal", fechaFinal);
        
        // EN DESDE Y HASTA VAN A ESTAR LAS ID DE LOS LUGARES 
        // SI LA ID ES 0 QUIERE DECIR QUE NO PUSIERON LUGAR
        // ELEGIR LUGAR ES OPCIONAL

        mV.addObject("permisosDiario", permisoDiarioService.buscarActivosEntreFechas(fechaInicial, fechaFinal));
        mV.addObject("permisosPeriodo", permisoPeriodoService.buscarActivosEntreFechas(fechaInicial, fechaFinal));
        return mV;
    }
    
}