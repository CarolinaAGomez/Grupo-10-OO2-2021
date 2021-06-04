package com.Grupo10OO22021.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.Grupo10OO22021.converters.PermisoDiarioConverter;
import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.LugarModel;
import com.Grupo10OO22021.models.PermisoDiarioModel;
import com.Grupo10OO22021.repository.IPermisoDiarioRepository;
import com.Grupo10OO22021.services.IPermisoDiarioService;

@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService {

	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;

	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;

	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso) {
		return permisoDiarioConverter.entityToModel(permisoDiarioRepository.save(permisoDiarioConverter.modelToEntity(permiso)));
	}

	@Override
	public Set<PermisoDiarioModel> findByPedido(int idPersona) {
		Set<PermisoDiarioModel> aux = new HashSet<>();
		for (PermisoDiario p : permisoDiarioRepository.findByPedido(idPersona)) {
			aux.add(permisoDiarioConverter.entityToModel(p));
    }
		return aux;
  }
  
	@Override
	public Set<PermisoDiarioModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate primeraFecha =  LocalDate.parse(fechaInicial, formatter);
		LocalDate segundaFecha = LocalDate.parse(fechaFinal, formatter);
		Set<PermisoDiarioModel> permisosActivos = new HashSet<>();
		for(PermisoDiario pd : permisoDiarioRepository.findAll()){
			if(pd.getFecha().equals(primeraFecha) || pd.getFecha().isAfter(primeraFecha) && pd.getFecha().isBefore(segundaFecha) || pd.getFecha().equals(segundaFecha)){
				permisosActivos.add(permisoDiarioConverter.entityToModel(pd));
			}
		}
		return permisosActivos;
	}

	@Override
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
							System.out.println("====" +pdm);
							auxDesdeHasta.add(pdm);	
						}
						lugarDesdeAux = new LugarModel(p.getIdLugar(),p.getLugar(),p.getCodigoPostal());
						System.out.println("====" + lugarDesdeAux);
					}
				}if(cont == 1) {
					if(p.getIdLugar()==hasta) {
						if(desde == 0) {
							auxDesdeHasta.add(pdm);
						}
						lugarHastaAux = new LugarModel(p.getIdLugar(),p.getLugar(),p.getCodigoPostal());
						System.out.println("==="+ lugarHastaAux);
						
					}
				}
				cont++;
			}
			if(lugarDesdeAux != null && lugarHastaAux != null) {
				if(lugarDesdeAux.getIdLugar() == desde && lugarHastaAux.getIdLugar() == hasta) {
					System.out.println("Esto tendria que no hacerlo" + pdm);
					auxDesdeHasta.add(pdm);
				}
			}
			
		}
		return auxDesdeHasta;
	}
}