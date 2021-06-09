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
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.repository.IPersonaRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;
import com.Grupo10OO22021.services.IPersonaService;
import com.Grupo10OO22021.services.impl.PermisoDiarioService;
import com.Grupo10OO22021.services.impl.PermisoService;
import com.Grupo10OO22021.services.impl.PersonaService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@RestController
@RequestMapping("/generacionqr")
public class QrGeneratorController {
	   @Autowired
	    
	    public PermisoDiarioService permisoDiarioService;
	   @Autowired
	  public  PersonaService personaService;
	   
	   @Autowired
	   
	    public PermisoService permisoService;
	   
	   /*
	   //para hola mundo
	   
	   @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
		public BufferedImage generateQRCodeImage(@RequestParam String URL) throws Exception {

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(URL,BarcodeFormat.QR_CODE, 250, 250);
			return MatrixToImageWriter.toBufferedImage(bitMatrix);
		}
	   */
	   
	   
	   
	//ESTA OK
	@GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImage(@RequestParam("idPermiso") int idPermiso,@RequestParam String URL) throws Exception {

		//System.out.println("esto es idPermiso"+idPermiso);
		PermisoDiarioModel per=null;
		
		 ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);
		 mV.addObject("permiso_diario",permisoDiarioService.findByPedido(idPermiso));
		 
		 for(PermisoDiarioModel p : permisoDiarioService.findByPedido(idPermiso)) 
			per=p; 
			
		System.out.println("esto es per"+per);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(URL+"nombre="+per.getPedido().getNombre()+"&apellido="+per.getPedido().getApellido()
				+"&dni="+per.getPedido().getDni()+"&motivo="+per.getMotivo()+"&fecha="+per.getFecha(),BarcodeFormat.QR_CODE, 250, 250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	
	/*
	
	@GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImage(@RequestParam("idPersona") int idPersona,@RequestParam String URL) throws Exception {

		System.out.println(idPersona);
		
		 ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);
		 mV.addObject("permiso_diario",permisoDiarioService.findByPedido(idPersona));
		
		 Persona p = personaRepository.findByIdPersona(idPersona);
		System.out.println(p);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(URL+"nombre="+p.getNombre(), BarcodeFormat.QR_CODE, 250, 250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
		
		  <a target="_blank" th:href="@{/generacionqr/?URL=https://carolinaagomez.github.io/PermisoDiario.html?(idPersona=${permiso.pedido.idPersona},nombre=${permiso.pedido.nombre})}">VER CODIGO QR</a>
		
	}
	}
	*/
	
	/*
	@GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImage(@RequestParam("idPermiso") int idPermiso,@RequestParam String URL) throws Exception {

		System.out.println(idPermiso);
		PermisoDiario per=null;
		
		 ModelAndView mV = new ModelAndView(ViewRouteHelper.PERMISO_VISTA_TRAER_POR_PERSONA);
		 mV.addObject("permiso_diario",permisoDiarioService.findByPedido(idPermiso));
		 
		 for(PermisoDiario p : permisoRepository.findByPedido(idPermiso)) 
			 
		 if(p.getPedido().equals(personaRepository.findByIdPersona(idPermiso))) {
			per=p; 
			
		 }
		
		// Persona p = personaRepository.findByIdPersona(idPermiso);
		System.out.println(per);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(URL+"nombre="+per.getPedido().getNombre()+"&apellido="+per.getPedido().getApellido()
				+"&dni="+per.getPedido().getDni()+"&motivo="+per.getMotivo()+"&fecha="+per.getFecha(),BarcodeFormat.QR_CODE, 250, 250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
*/
}
