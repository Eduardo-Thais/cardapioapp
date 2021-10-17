package com.cardapioapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Produto> produto;
	@ManyToOne
	private Mesa mesa;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pedido;

	
	private float conta;
	
	
	
	public Pedido(float conta) {
		super();
		this.conta = conta;

		
	}
	
	public Pedido() {
		
	}
	
	
	public float getNome() {
		return conta;
	}
	public void setNome(float conta) {
		this.conta = conta;
	}
	
	
	
	
}
