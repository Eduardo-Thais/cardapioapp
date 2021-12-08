package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(mappedBy = "produto")
	private List<ProdutoPedido> produtoPedido = new ArrayList<>(0);
	
	@Column(name= "descricao", nullable=false)
	private String descricao;
	@NotNull
	private String tipo;
	@NotNull
	private float valor;
	
	
	public Produto(String descricao, String tipo, float valor) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		
		
	}
	
	public Produto() {
		
	}
	
	
	



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	
	
	
	
	
	
}
