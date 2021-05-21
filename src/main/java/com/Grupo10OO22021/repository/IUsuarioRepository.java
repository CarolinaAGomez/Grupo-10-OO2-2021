package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Usuario;




@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> { //que es serializable?
	
	// EL REPOSITORY TRABAJA DIRECTAMENTE CON LA BASE DE DATOS.(ENTITY)
		
	public Usuario findByIdUsuario(long idUsusario);
	
	//@Query (" SELECT U from Usuario where u.dni = (:dni)")  // NO HACE FALTA , CON EL ATRIBUTO YA LO TRAE.
	public abstract Usuario findByDni(int dni);
	
	
	public Usuario findByUsername(String Username);

}
