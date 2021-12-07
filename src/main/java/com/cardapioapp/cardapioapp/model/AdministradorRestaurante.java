package com.cardapioapp.cardapioapp.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class AdministradorRestaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "restaurante",referencedColumnName = "id", nullable=false)
	private Restaurante restaurante;
	
	@ManyToOne
	@JoinColumn(name = "administrador",referencedColumnName = "id", nullable=false)
	private Administrador administrador;

	
	
	
	
	public AdministradorRestaurante() {
		super();
	}
	
	
	
	public AdministradorRestaurante(long id) {
		super();
		this.id = id;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	

	
	
	
	
}
