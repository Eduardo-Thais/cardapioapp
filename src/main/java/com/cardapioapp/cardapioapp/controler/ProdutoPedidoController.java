package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.ProdutoPedido;
import com.cardapioapp.cardapioapp.repository.ProdutoPedidoRepository;

@RestController
public class ProdutoPedidoController {
	@Autowired
	private ProdutoPedidoRepository ppr;

	
	
	@RequestMapping(value = "/cadastrarPP", method = RequestMethod.POST)
	public boolean cadastrarProdutoPedido(@RequestBody ProdutoPedido cadastro){
		
		
		ppr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarPP")
	public Iterable<ProdutoPedido> listarProdutoPedido() {
		Iterable<ProdutoPedido> produtoPedido = ppr.findAll();
		return produtoPedido;
	}
	
	@RequestMapping(value = "/deletaProdutoPedido/{id}")
	public boolean deletaProdutoPedido(@PathVariable long id) {
		ProdutoPedido produtoPedido = ppr.findById(id);
		ppr.delete(produtoPedido);
		
		return true;
	}
	
	@RequestMapping(value = "/editaProdutoPedido")
	public boolean editaProdutoPedido(@RequestBody ProdutoPedido cadastro, long id) {
		cadastro.setId(id);
		
		ppr.save(cadastro);
		
		
		return true;
	}
}
