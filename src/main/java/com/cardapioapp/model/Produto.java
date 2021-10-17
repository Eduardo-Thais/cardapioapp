package com.cardapioapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long produto;

	@ManyToMany
	private List<Pedido> pedido;
	
	private String descrição;
	private String tipo;
	private float valor;
	private float quantidade;
	
	public Produto(String descrição, String tipo, float valor, float quantidade) {
		super();
		this.descrição = descrição;
		this.tipo = tipo;
		this.valor = valor;
		this.quantidade = quantidade;
		
	}
	
	public Produto() {
		
	}
	
	
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
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
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
}
