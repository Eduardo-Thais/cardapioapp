package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	
	@OneToMany(mappedBy="restaurante")
	private List<Mesa> mesa = new ArrayList<>(0);
	
	
	
	@OneToMany(mappedBy = "restaurante")
	private List<AdministradorRestaurante> administradorRestaurante = new ArrayList<>(0);

	
	private String nome;
	private String cnpj;
	
	
	public Restaurante(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		
	}
	
	public Restaurante() {
		
	}
	
	
	
	
	public List<AdministradorRestaurante> getAdministradorRestaurante() {
		return administradorRestaurante;
	}

	public void setAdministradorRestaurante(List<AdministradorRestaurante> administradorRestaurante) {
		this.administradorRestaurante = administradorRestaurante;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
