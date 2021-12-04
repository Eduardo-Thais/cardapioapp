package com.cardapioapp.cardapioapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;



@Entity
@Table(name = "Administrador")
public class Administrador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Adiministrador_Restaurante", 
        joinColumns = { @JoinColumn(name = "administrador_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "restaurante_id") }
    )
	private List<Restaurante> restaurante = new ArrayList<Restaurante>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nome;
	@NotNull
	private String senha;
	
	public Administrador(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public Administrador() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}
