package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Mesa;


public interface MesaRepository extends CrudRepository<Mesa, String>{
	Mesa findById(long id);
}
