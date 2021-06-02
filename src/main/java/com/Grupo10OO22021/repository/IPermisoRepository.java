package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Permiso;


@Repository("permisoRepository")
public interface IPermisoRepository  extends JpaRepository<Permiso, Serializable>{
	
	
	//@Query("SELECT p from permiso p inner join fetch where p.pedido pe where pe.idPersona = (:idPersona)")
	//@Query("SELECT p from permiso p  where p.pedido pe where pe.idPersona = (:idPersona)")
	public Permiso findByPedido(int idPersona);
}
