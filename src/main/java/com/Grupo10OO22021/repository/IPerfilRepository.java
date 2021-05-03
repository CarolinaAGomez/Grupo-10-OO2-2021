package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Grupo10OO22021.entities.Perfil;



@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable> {
	
	public Perfil findByIdPerfil(long id);
	
	//@Query("Select r from Rol where r.nombreRol= (:nombre)") //NO HACE FALTA CON EL FINDBYNOMBREDELATRIBUTO LO TRAE
	public abstract Perfil findByNombreRol(String nombre);

}
