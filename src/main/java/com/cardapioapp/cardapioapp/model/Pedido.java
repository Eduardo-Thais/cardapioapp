package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;


@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "mesa",referencedColumnName = "id", nullable = false)
	private Mesa mesa;
	
	@OneToMany(mappedBy = "pedido")
	private List<ProdutoPedido> produtoPedido = new ArrayList<>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private float conta;
	
	
	

	public Pedido(float conta) {
		super();
		this.conta = conta;

		
	}
	
	public Pedido() {
		
	}
	
	
	
	

	public float getConta() {
		return conta;
	}

	public void setConta(float conta) {
		this.conta = conta;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getNome() {
		return conta;
	}
	public void setNome(float conta) {
		this.conta = conta;
	}
	
	
	
	
}
