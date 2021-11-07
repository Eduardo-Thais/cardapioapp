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

	@OneToMany(mappedBy="mesa",orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	@ManyToOne
	@JoinColumn(name = "restaurante", nullable = false)
	private Restaurante restaurante = new Restaurante();
	
	private String qrcode;
	
	
	
	public Mesa(String qrcode) {
		super();
		this.qrcode = qrcode;
		
	}
	
	public Mesa() {
		
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
