package com.Grupo10OO22021.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Lugar")
public class Lugar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugar;

	@Column(name = "lugar")
	private String lugar;
	@Column(name = "codigoPostal")
	private String codigoPostal;
	/*
	 * @ManyToMany(cascade = CascadeType.MERGE)
	 * 
	 * @JoinTable( name = "permiso_lugar", joinColumns = {@JoinColumn(name =
	 * "lugar_id")}, inverseJoinColumns = {@JoinColumn(name = "persona_id")} )
	 */
	// private Set<Permiso> permiso;

	@ManyToMany(mappedBy = "desdeHasta") // Mapeado con el campo Roles de Usuario
	private Set<Permiso> permiso;

	public Lugar() {}

	public Lugar(int idLugar, String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Set<Permiso> getPermiso() {
		return permiso;
	}

	public void setPermiso(Set<Permiso> permiso) {
		this.permiso = permiso;
	}

	public boolean add(Permiso permiso) {
		return this.permiso.add(permiso);
	}
	
	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + ", permiso=" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLugar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lugar other = (Lugar) obj;
		if (idLugar != other.idLugar)
			return false;
		return true;
	}
}
/*
 * 
 * public void agregarPermisoaLugar( Permiso p) { permiso.add(p);
 * 
 * }
 * 
 * 
 */

