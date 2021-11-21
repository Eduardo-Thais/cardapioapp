package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante, String>{
	Restaurante findById(long id);
}
