package com.cardapioapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mesa implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mesa;

	@OneToMany
	private Pedido pedido;
	@ManyToOne
	private Restaurante restaurante;
	
	private String qrcode;
	
	
	
	public Mesa(String qrcode) {
		super();
		this.qrcode = qrcode;
		
	}
	
	public Mesa() {
		
	}
	
	
	public String getNome() {
		return qrcode;
	}
	public void setNome(String qrcode) {
		this.qrcode = qrcode;
	}

	
	
}
