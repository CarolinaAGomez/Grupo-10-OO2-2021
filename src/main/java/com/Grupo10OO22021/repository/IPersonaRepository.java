package com.Grupo10OO22021.repository;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

import com.Grupo10OO22021.entities.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>  {
    
}
