package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo10OO22021.entities.Rodado;

public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{

	public Rodado findByIdRodado(int id);
}
