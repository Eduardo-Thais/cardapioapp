package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Administrador;
import com.cardapioapp.cardapioapp.model.Restaurante;
import com.cardapioapp.cardapioapp.repository.RestauranteRepository;

@RestController
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository rr;
	
	@RequestMapping(value = "/cadastrarRestaurante", method = RequestMethod.POST)
	public boolean cadastrarRestaurante(@RequestBody Restaurante cadastro){
		
		
		
		rr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarRestaurante")
	public Iterable<Restaurante> listarRestaurante() {
		Iterable<Restaurante> restaurante = rr.findAll();
		return restaurante;
	}
	
	@RequestMapping(value = "/deletaRestaurante/{id}")
	public boolean deletaRestaurante(@PathVariable long id) {
		Restaurante restaurante = rr.findById(id);
		rr.delete(restaurante);
		
		return true;
	}
	
	@RequestMapping(value = "/editaRestaurante")
	public boolean editaRestaurante(@RequestBody Restaurante cadastro, long id) {
		cadastro.setId(id);
		
		rr.save(cadastro);
		
		
		return true;
	}
	
}
