package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{
	Produto findById(long id);
}
