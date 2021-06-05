package com.Grupo10OO22021.repository;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository  extends JpaRepository<Permiso, Serializable>{
	
	@Query("SELECT p from Permiso p inner join fetch p.pedido pe where pe.idPersona = (:idPersona)")
	public Set<Permiso> findByPedido(int idPersona);

}
