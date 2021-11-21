package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


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
	
	
	private String qrcode;
	
	
	
	public Mesa(String qrcode) {
		super();
		this.qrcode = qrcode;
		
	}
	
	public Mesa() {
		
	}
	
	
	

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
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


	public String getNome() {
		return qrcode;
	}
	public void setNome(String qrcode) {
		this.qrcode = qrcode;
	}

	
	
}
