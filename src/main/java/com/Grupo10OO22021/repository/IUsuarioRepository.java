package com.Grupo10OO22021.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Grupo10OO22021.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public Usuario findByIdUsuario(long idUsusario);
	
	public abstract Usuario findByDni(int dni);

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.idUsuario = (:idUsuario)")
	public abstract Usuario findByIdUsuarioAndFetchPerfilEagerly(@Param("idUsuario") long idUsuario);

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchPerfilEagerly(@Param("username") String username);
	
	public Usuario findByUsername(String Username);

}
