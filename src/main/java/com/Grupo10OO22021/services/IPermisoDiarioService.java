package com.Grupo10OO22021.services;

import java.util.List;
import java.util.Set;

import com.Grupo10OO22021.entities.PermisoDiario;
import com.Grupo10OO22021.models.PermisoDiarioModel;

public interface IPermisoDiarioService {
	
	public Set<PermisoDiarioModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal);

	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permiso);

	public Set<PermisoDiarioModel> findByPedido(int idPersona);
	
	public Set<PermisoDiarioModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal, int desde, int hasta);
	
	public PermisoDiarioModel findByidPermiso(int idPermiso);
	
	public List<PermisoDiario> traerPermisosDiario();
}
