package com.Grupo10OO22021.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.Grupo10OO22021.converters.PermisoPeriodoConverter;

import com.Grupo10OO22021.entities.PermisoPeriodo;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoPeriodoModel;
import com.Grupo10OO22021.repository.IPermisoPeriodoRepository;
import com.Grupo10OO22021.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService {
	
	@Autowired
	private PermisoPeriodoConverter permisoPeriodoConverter;
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Override
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permiso) {
		 return permisoPeriodoConverter.entityToModel(permisoPeriodoRepository.save(permisoPeriodoConverter.modelToEntity(permiso)));
	}

	@Override
	public Set<PermisoPeriodoModel> findByPedido(int idPersona) {
		Set<PermisoPeriodoModel> aux = new HashSet<>();
		for (PermisoPeriodo p : permisoPeriodoRepository.findByPedido(idPersona)) {
			aux.add(permisoPeriodoConverter.entityToModel(p));
		}
		return aux;
	}

	@Override
	public Set<PermisoPeriodoModel> traerPermisoxRodado(int idRodado){
		Set<PermisoPeriodoModel> permisos = new HashSet<>();
		for(PermisoPeriodo pp : permisoPeriodoRepository.findByRodado(idRodado)){
			permisos.add(permisoPeriodoConverter.entityToModel(pp));
		}
		return permisos;
	}

	@Override
	public Set<PermisoPeriodoModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate primeraFecha =  LocalDate.parse(fechaInicial, formatter);
		LocalDate segundaFecha = LocalDate.parse(fechaFinal, formatter);
		Set<PermisoPeriodoModel> permisosActivos = new HashSet<>();
		for(PermisoPeriodo pp : permisoPeriodoRepository.findAll()){
			System.out.println(pp.getFecha());
			if(pp.getFecha().equals(primeraFecha) || pp.getFecha().isAfter(primeraFecha) && pp.getFecha().isBefore(segundaFecha) || pp.getFecha().equals(segundaFecha)){
				System.out.println("activo por fecha que empieza el periodo del permiso");
				permisosActivos.add(permisoPeriodoConverter.entityToModel(pp));
			}else if(pp.getFecha().plusDays(pp.getCantDias()).equals(primeraFecha) || pp.getFecha().plusDays(pp.getCantDias()).isAfter(primeraFecha) && pp.getFecha().plusDays(pp.getCantDias()).isBefore(segundaFecha) || pp.getFecha().plusDays(pp.getCantDias()).equals(segundaFecha)){
				System.out.println("activo por que el permiso termina dentro de los parametros");
				permisosActivos.add(permisoPeriodoConverter.entityToModel(pp));
			}else if(pp.getFecha().isBefore(primeraFecha) && pp.getFecha().plusDays(pp.getCantDias()).isAfter(segundaFecha)){
				System.out.println("activo por que el periodo parametro está dentro del periodoPermiso");
				permisosActivos.add(permisoPeriodoConverter.entityToModel(pp));
			}
		}
		return permisosActivos;
	}

	@Override
	public Set<PermisoPeriodoModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal, int desde,
			int hasta) {
		Set<PermisoPeriodoModel>  permisosPeriodo = new HashSet<>();
		for (PermisoPeriodoModel ppm : buscarActivosEntreFechas(fechaInicial,fechaFinal)) {
			Set<LugarModel> desdeHasta = ppm.getDesdeHasta();
			int cont = 0;
			LugarModel lugarDesdeAux = null;
			LugarModel lugarHastaAux = null;
			for(LugarModel l : desdeHasta){
				if(cont == 0) {
					if(l.getIdLugar() == desde) {
						if(hasta == 0) {
							permisosPeriodo.add(ppm);	
						}
						lugarDesdeAux = new LugarModel(l.getIdLugar(),l.getLugar(),l.getCodigoPostal());
					}
				}if(cont == 1) {
					if(l.getIdLugar() == hasta) {
						if(desde == 0) {
							permisosPeriodo.add(ppm);
						}
						lugarHastaAux = new LugarModel(l.getIdLugar(),l.getLugar(),l.getCodigoPostal());						
					}
				}
				cont++;
			}
			if(lugarDesdeAux != null && lugarHastaAux != null) {
				if(lugarDesdeAux.getIdLugar() == desde && lugarHastaAux.getIdLugar() == hasta) {
					permisosPeriodo.add(ppm);
				}
			}
		}
		return permisosPeriodo;
	}

	@Override
	public PermisoPeriodoModel findByidPermiso(int idPermiso) {
		
		return permisoPeriodoConverter.entityToModel(permisoPeriodoRepository.findByidPermiso(idPermiso));
	}

	
	/*@Override
	public Set<PermisoDiarioModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal, int desde, int hasta) {
		Set<PermisoDiarioModel> auxDesdeHasta = new HashSet<>();
		for (PermisoDiarioModel pdm : buscarActivosEntreFechas(fechaInicial,fechaFinal)) {
			Set<LugarModel> auxLugar =  pdm.getDesdeHasta();
			int cont = 0;
			LugarModel lugarDesdeAux = null;
			LugarModel lugarHastaAux = null;
			for (LugarModel p: auxLugar) {
				if(cont == 0) {
					if(p.getIdLugar() == desde) {
						if(hasta == 0) {
							auxDesdeHasta.add(pdm);	
						}
						lugarDesdeAux = new LugarModel(p.getIdLugar(),p.getLugar(),p.getCodigoPostal());
					}
				}if(cont == 1) {
					if(p.getIdLugar()== hasta) {
						if(desde == 0) {
							auxDesdeHasta.add(pdm);
						}
						lugarHastaAux = new LugarModel(p.getIdLugar(),p.getLugar(),p.getCodigoPostal());						
					}
				}
				cont++;
			}
			if(lugarDesdeAux != null && lugarHastaAux != null) {
				if(lugarDesdeAux.getIdLugar() == desde && lugarHastaAux.getIdLugar() == hasta) {
					auxDesdeHasta.add(pdm);
				}
			}
			
		}
		return auxDesdeHasta;
	}*/
}
