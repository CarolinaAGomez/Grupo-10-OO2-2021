package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable>{

	public Permiso findByIdPermiso(int id);
}
