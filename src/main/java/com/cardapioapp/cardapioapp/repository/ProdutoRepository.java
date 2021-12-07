package com.cardapioapp.cardapioapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{
	Produto findById(long id);
	List<Produto> findByTipoContains(String tipo);
}
