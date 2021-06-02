package com.Grupo10OO22021.services;


import java.util.Set;

import com.Grupo10OO22021.models.PermisoDiarioModel;

public interface IPermisoDiarioService {
	
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso);
	
	public Set<PermisoDiarioModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal);
	


}
