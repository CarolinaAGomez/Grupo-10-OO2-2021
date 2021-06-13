package com.Grupo10OO22021.controller;

import java.awt.image.BufferedImage;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo10OO22021.entities.Permiso;
import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.entities.Persona;
import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.models.PermisoPeriodoModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.repository.IPersonaRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPersonaService;
import com.Grupo10OO22021.services.impl.PermisoDiarioService;
import com.Grupo10OO22021.services.impl.PermisoPeriodoService;
import com.Grupo10OO22021.services.impl.PermisoService;
import com.Grupo10OO22021.services.impl.PersonaService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/generacionqr")
public class QrGeneratorController {
	
	Logger logger = LoggerFactory.getLogger(PermisoController.class);
	
	@Autowired
	public PermisoDiarioService permisoDiarioService;

	@Autowired
	public PersonaService personaService;

	@Autowired
	public PermisoPeriodoService permisoPeriodoService;
	
	
	@GetMapping(value = ("/diario"), produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImage(@RequestParam("idPermiso") int idPermiso, @RequestParam String URL)
			throws Exception {
		System.out.println("esto es idPermiso" + idPermiso);
		PermisoDiarioModel per = null;
		int cont = 0;
		LugarModel desde = null;
		LugarModel hasta = null;

		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);

		per = permisoDiarioService.findByidPermiso(idPermiso);
		
		for(LugarModel l : per.getDesdeHasta()) {
			
			if (cont == 0) {
				desde = l;
			}if (cont == 1) {
				hasta = l;
			}
			
			cont ++;
		}

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(
				URL + "nombre=" + per.getPedido().getNombre() + "&apellido=" + per.getPedido().getApellido() + "&dni="
						+ per.getPedido().getDni() + "&motivo=" + per.getMotivo() + "&fecha=" + per.getFecha()  + "&desde="+ desde.getLugar()+ "&hasta"+ hasta.getLugar(),
				BarcodeFormat.QR_CODE, 250, 250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@GetMapping(value = ("/periodo"), produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImagePeriodo(@RequestParam("idPermiso") int idPermiso, @RequestParam String URL)
			throws Exception {

		System.out.println("esto es idPermiso" + idPermiso);
		PermisoPeriodoModel per = null;
		int cont = 0;
		LugarModel desde = null;
		LugarModel hasta = null;

		ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);

		per = permisoPeriodoService.findByidPermiso(idPermiso);
		
		for(LugarModel l : per.getDesdeHasta()) {
			
			if (cont == 0) {
				desde = l;
			}if (cont == 1) {
				hasta = l;
			}
			
			cont ++;
		}

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(URL + "nombre=" + per.getPedido().getNombre() + "&apellido="
				+ per.getPedido().getApellido() + "&dni=" + per.getPedido().getDni() + "&cantDias=" + per.getCantDias()
				+ "&fecha=" + per.getFecha() + "&desde="+ desde.getLugar()+ "&hasta"+ hasta.getLugar() + "&vehiculo=" + per.getRodado().getDominio(), BarcodeFormat.QR_CODE, 250,
				250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

}
