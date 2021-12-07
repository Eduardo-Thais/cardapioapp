package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.ProdutoPedido;

public interface ProdutoPedidoRepository extends CrudRepository<ProdutoPedido, String>{
	ProdutoPedido findById(long id);
}
