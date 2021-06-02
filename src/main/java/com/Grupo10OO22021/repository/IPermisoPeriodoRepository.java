package com.Grupo10OO22021.repository;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {

	@Query("From PermisoPeriodo pp where pp.rodado.idRodado =(:idRodado) ")
	public abstract List<PermisoPeriodo> FindByIdRodado(int idRodado);

	@Query("SELECT p from PermisoPeriodo p inner join fetch p.pedido pe where pe.idPersona = (:idPersona) ")
	public Set<PermisoPeriodo> findByPedido(int idPersona);
}
