package com.Grupo10OO22021.repository;

import java.io.Serializable;
import java.util.Set;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {

	  @Query("SELECT p from PermisoPeriodo p inner join fetch p.pedido pe where pe.idPersona = (:idPersona) ")
	  public Set<PermisoPeriodo> findByPedido(int idPersona);
  
    @Query("SELECT pp FROM PermisoPeriodo pp INNER JOIN pp.rodado WHERE pp.rodado.idRodado = (:idRodado)")
    public abstract Set<PermisoPeriodo> findByRodado(@Param("idRodado") int idRodado);

    /*@Query("SELECT pp FROM PermisoPeriodo pp INNER JOIN pp.rodado WHERE pp.fecha BETWEEN :fechaInicial AND :fechaFinal ")
    public abstract Set<PermisoPeriodo> findBetweenDates(@Param("fechaInicial") String fechaInicial,@Param("fechaInicial") String fechaFinal);
    */
}
