package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Administrador;
import com.cardapioapp.cardapioapp.repository.AdministradorRepository;


@RestController
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository ar;
	
	@RequestMapping(value = "/cadastrarAdministrador", method = RequestMethod.POST)
	public boolean cadastrarAdministrador(@RequestBody Administrador cadastro){
		
		ar.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarAdministrador")
	public Iterable<Administrador> listarAdministrador() {
		Iterable<Administrador> administrador = ar.findAll();
		return administrador;
	}
	
	@RequestMapping(value = "/deletaAdministrador/{id}")
	public boolean deletaAdministrador(@PathVariable long id) {
		Administrador administrador = ar.findById(id);
		ar.delete(administrador);
		
		return true;
	}
	
	@RequestMapping(value = "/editaAdministrador")
	public boolean editaAdministrador(@RequestBody Administrador cadastro, long id) {
		cadastro.setId(id);
		
		ar.save(cadastro);
		
		
		return true;
	}
	
}
