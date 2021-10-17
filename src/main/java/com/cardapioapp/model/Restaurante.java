package com.cardapioapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private Mesa mesa;
	
	@ManyToOne
	private Administrador administrador;
	
	private String nome;
	private int cnpj;
	
	
	public Restaurante(String nome, int cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		
	}
	
	public Restaurante() {
		
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
