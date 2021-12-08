package com.cardapioapp.cardapioapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardapioapp.cardapioapp.model.ProdutoPedido;

public interface ProdutoPedidoRepository extends CrudRepository<ProdutoPedido, String>{
	ProdutoPedido findById(long id);
	List<ProdutoPedido> findByPedidoId(long id);
}
