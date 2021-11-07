package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


@Entity
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	
	@OneToMany(mappedBy="restaurante",orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Mesa> mesa = new ArrayList<Mesa>();
	
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
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
