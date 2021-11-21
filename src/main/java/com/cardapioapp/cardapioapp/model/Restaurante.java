package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


@Entity
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	
	@OneToMany(mappedBy="restaurante")
	private List<Mesa> mesa = new ArrayList<>(0);

	
	
	
	@ManyToMany(mappedBy="restaurante", cascade = CascadeType.ALL)
	private List<Administrador> administrador = new ArrayList<Administrador>();
	
	private String nome;
	private String cnpj;
	
	
	public Restaurante(String nome, String cnpj) {
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
