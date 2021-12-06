package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;




@Entity
public class Mesa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(mappedBy="mesa")
	private List<Pedido> pedidos = new ArrayList<>(0);
	
	

	@ManyToOne
	@JoinColumn(name = "restaurante",referencedColumnName = "id", nullable=false)
	private Restaurante restaurante;
	
	
	@Lob
	@Column(nullable=false, columnDefinition="mediumblob")
	private byte[] qrcode;
	
	
	
	private String nome;
	
	public Mesa(byte[] qrcode,String nome) {
		super();
		this.qrcode = qrcode;
		this.nome = nome;
	}




	public Mesa() {
		
	}
	
	
	

	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public byte[] getQrcode() {
		return qrcode;
	}

	public void setQrcode(byte[] qrcode) {
		this.qrcode = qrcode;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
