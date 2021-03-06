package com.Grupo10OO22021.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Permiso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	protected Persona pedido;

	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	protected LocalDate fecha;

	//@ManyToMany(mappedBy = "permiso")
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="permiso_lugar", 
		joinColumns=@JoinColumn (name="permiso_id"),
		inverseJoinColumns= @JoinColumn(name="lugar_id")
		)
	private Set<Lugar> desdeHasta=new HashSet<>();

	public Permiso() {
	}

	public Permiso(int idPermiso, Persona pedido, LocalDate fecha, Set<Lugar> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}

	public Permiso(int idPermiso, Persona pedido, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPedido() {
		return pedido;
	}

	public void setPedido(Persona pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	public void agregarLugaraPermiso( Lugar l) {
		desdeHasta.add(l);	
	}
}