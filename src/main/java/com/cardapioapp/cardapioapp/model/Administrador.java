package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Administrador")
public class Administrador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Restaurante restaurante;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String senha;
	
	public Administrador(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public Administrador() {
		
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}
