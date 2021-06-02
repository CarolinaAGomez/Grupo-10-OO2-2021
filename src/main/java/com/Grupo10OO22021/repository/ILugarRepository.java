package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Lugar;


@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository <Lugar, Serializable> {
	
	public Lugar findByIdLugar(int idLugar);
	

}
