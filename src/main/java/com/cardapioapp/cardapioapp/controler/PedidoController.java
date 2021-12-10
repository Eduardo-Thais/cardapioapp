package com.cardapioapp.cardapioapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Mesa;
import com.cardapioapp.cardapioapp.model.Pedido;
import com.cardapioapp.cardapioapp.repository.MesaRepository;
import com.cardapioapp.cardapioapp.repository.PedidoRepository;


@RestController
public class PedidoController {

	@Autowired
	private PedidoRepository pr;
	
	@Autowired
	private MesaRepository mr;
	
	@RequestMapping(value = "/cadastrarPedido", method = RequestMethod.POST)
	public boolean cadastrarPedido(@RequestBody Pedido cadastro){
		
		pr.save(cadastro);
		
		return true;
		
	}
	
	@RequestMapping(value = "/cadastrarPedido/{mesaNome}", method = RequestMethod.POST)
	public boolean cadastrarPedidoPorMesa(@RequestBody Pedido cadastro,@PathVariable String mesaNome){
		Mesa mesaIn = mr.findByNome(mesaNome);
		cadastro.setMesa(mesaIn);
		
		pr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarPedido")
	public Iterable<Pedido> listarPedido() {
		Iterable<Pedido> pedido = pr.findAll();
		return pedido;
	}
	
	@RequestMapping(value = "/listarPedido/{mesaid}")
	public Pedido listaPedidoMesa(@PathVariable long mesaid) {
		Pedido pedido = pr.findByMesaId(mesaid);
		
		
		return pedido;
	}
	
	@RequestMapping(value = "/deletaPedido/{id}")
	public boolean deletaPedido(@PathVariable long id) {
		Pedido pedido = pr.findById(id);
		pr.delete(pedido);
		
		return true;
	}
	
	@RequestMapping(value = "/editaPedido/{id}")
	public boolean editaPedido(@RequestBody Pedido cadastro, @PathVariable long id) {
		
		cadastro.setId(id);
		
		pr.save(cadastro);
		
		
		return true;
	}
	
	public boolean editaPedidoAutomatico(Pedido cadastro, long id) {
		cadastro.setId(id);
		
		pr.save(cadastro);
		
		
		return true;
	}
	
}
