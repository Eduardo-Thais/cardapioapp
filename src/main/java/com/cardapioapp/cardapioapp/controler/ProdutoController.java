package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Produto;
import com.cardapioapp.cardapioapp.repository.ProdutoRepository;



@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public boolean cadastrarProduto(@RequestBody Produto cadastro){
		
		pr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarProduto")
	public Iterable<Produto> listarProduto() {
		Iterable<Produto> produto = pr.findAll();
		return produto;
	}
	
	@RequestMapping(value = "/deletaProduto/{id}")
	public boolean deletaProduto(@PathVariable long id) {
		Produto produto = pr.findById(id);
		pr.delete(produto);
		
		return true;
	}
	
	@RequestMapping(value = "/editaProduto")
	public boolean editaProduto(@RequestBody Produto cadastro, long id) {
		cadastro.setId(id);
		
		pr.save(cadastro);
		
		
		return true;
	}

}
