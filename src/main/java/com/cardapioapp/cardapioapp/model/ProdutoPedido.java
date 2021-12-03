package com.cardapioapp.cardapioapp.model;

import javax.persistence.*;

@Entity
@Table(name="Produto_Pedido")
public class ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int quantidade;
	
	
	@ManyToOne
	@MapsId("id")
	private Pedido pedido;
	
	@ManyToOne
	@MapsId("id")
	private Produto produto;
	
	
	
	public ProdutoPedido(int quantidade) {
		super();
		this.quantidade = quantidade;

		
	}
	
	public ProdutoPedido() {
		
	}
	
	
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
}
