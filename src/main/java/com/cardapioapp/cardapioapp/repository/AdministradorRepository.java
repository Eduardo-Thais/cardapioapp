package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, String>{
	Administrador findById(long id);
}
