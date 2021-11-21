package com.cardapioapp.cardapioapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String>{
	Pedido findById(long id);
}
