package com.Grupo10OO22021.services;

import java.util.Set;

import com.Grupo10OO22021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {

	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permiso);

	public Set<PermisoPeriodoModel> findByPedido(int idPersona);

	public Set<PermisoPeriodoModel> traerPermisoxRodado(int idRodado);

	public Set<PermisoPeriodoModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal);
  
	public Set<PermisoPeriodoModel> buscarActivosEntreFechas(String fechaInicial, String fechaFinal,int desde,int hasta);
}
