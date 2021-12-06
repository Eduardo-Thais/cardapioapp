package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.AdministradorRestaurante;


public interface AdministradorRestauranteRepository extends CrudRepository<AdministradorRestaurante, String>{
	AdministradorRestaurante findById(long id);
}
