package com.Grupo10OO22021.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable> {

	public abstract List<Permiso> findAll();

	 @Query("SELECT p from Permiso p inner join fetch where p.pedido pe where pe.idPersona = (:idPersona)")
	 public Permiso findByPedido(int idPersona);
	 
	 //@Query("SELECT p from permiso p where p.pedido pe where pe.idPersona = (:idPersona)")

}
