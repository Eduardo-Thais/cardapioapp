package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.AdministradorRestaurante;
import com.cardapioapp.cardapioapp.repository.AdministradorRestauranteRepository;

@RestController
@CrossOrigin(origins = "https://tcc-restaurante.herokuapp.com")
public class AdministradorRestauranteController {
	
	@Autowired
	private AdministradorRestauranteRepository arr;

	
	
	@RequestMapping(value = "/cadastrarAR", method = RequestMethod.POST)
	public boolean cadastrarAdministradorRestaurante(@RequestBody AdministradorRestaurante cadastro){

		
		
		arr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarAR")
	public Iterable<AdministradorRestaurante> listarAdministradorRestaurante() {
		Iterable<AdministradorRestaurante> administradorRestaurante = arr.findAll();
		return administradorRestaurante;
	}
	
	@RequestMapping(value = "/deletaAR/{id}")
	public boolean deletaAdministradorRestaurante(@PathVariable long id) {
		AdministradorRestaurante administradorRestaurante = arr.findById(id);
		arr.delete(administradorRestaurante);
		
		return true;
	}
	
	@RequestMapping(value = "/editaAR")
	public boolean editaAdministradorRestaurante(@RequestBody AdministradorRestaurante cadastro, long id) {
		cadastro.setId(id);
		
		arr.save(cadastro);
		
		
		return true;
	}
}
