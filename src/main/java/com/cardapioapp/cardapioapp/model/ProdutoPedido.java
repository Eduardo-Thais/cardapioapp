package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
public class ProdutoPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private int quantidade;
	
	
	@ManyToOne
	@JoinColumn(name = "pedido",referencedColumnName = "id", nullable=false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto",referencedColumnName = "id", nullable=false)
	private Produto produto;
	
	
	
	
	
	public ProdutoPedido(long id, int quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}




	public ProdutoPedido() {
		
	}
	
	
	
	


	public Pedido getPedido() {
		return pedido;
	}




	public Produto getProduto() {
		return produto;
	}




	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
}
