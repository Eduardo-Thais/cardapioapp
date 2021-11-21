package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Mesa;
import com.cardapioapp.cardapioapp.repository.MesaRepository;

@RestController
public class MesaController {
	
	@Autowired
	private MesaRepository mr;
	
	@RequestMapping(value = "/cadastrarMesa", method = RequestMethod.POST)
	public boolean cadastrarMesa(@RequestBody Mesa cadastro){
		
		
		
		mr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarMesa")
	public Iterable<Mesa> listarMesa() {
		Iterable<Mesa> mesa = mr.findAll();
		return mesa;
	}
	
	@RequestMapping(value = "/deletaMesa")
	public boolean deletaMesa(long id) {
		Mesa mesa = mr.findById(id);
		mr.delete(mesa);
		
		return true;
	}
	
	@RequestMapping(value = "/editaMesa")
	public boolean editaMesa(@RequestBody Mesa cadastro, long id) {
		cadastro.setId(id);
		
		mr.save(cadastro);
		
		
		return true;
	}
}
