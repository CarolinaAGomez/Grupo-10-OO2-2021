package com.Grupo10OO22021.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.PermisoDiario;

@Repository("permisoDiarioRepository")

public interface IPermisoDiarioRepository extends JpaRepository<PermisoDiario, Serializable> {

	@Query("SELECT p from PermisoDiario p inner join fetch p.pedido pe where pe.idPersona = (:idPersona) ")
	public Set<PermisoDiario> findByPedido(int idPersona);
}
