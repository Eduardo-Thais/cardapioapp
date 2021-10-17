package com.cardapioapp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Administrador {
	
	@ManyToOne
	private Restaurante restaurante;
	
	private String nome;
	private String senha;
	
	public Administrador(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public Administrador() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}
