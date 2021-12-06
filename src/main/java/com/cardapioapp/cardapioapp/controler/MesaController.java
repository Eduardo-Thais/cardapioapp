package com.cardapioapp.cardapioapp.controler;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardapioapp.cardapioapp.model.Mesa;
import com.cardapioapp.cardapioapp.repository.MesaRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@RestController
public class MesaController {
	
	
	
	@Autowired
	private MesaRepository mr;
	
	@RequestMapping(value = "/cadastrarMesa", method = RequestMethod.POST)
	public boolean cadastrarMesa(@RequestBody Mesa cadastro) throws Exception{
		
		String path = "D:\\qrcode\\" + cadastro.getNome() + ".jpg";
		BitMatrix matrix = new MultiFormatWriter().encode(cadastro.getNome(), BarcodeFormat.QR_CODE, 500, 500);
		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
		
		mr.save(cadastro);
		
		return true;
		
	}
	
	
	@RequestMapping("/listarMesa")
	public Iterable<Mesa> listarMesa() {
		Iterable<Mesa> mesa = mr.findAll();
		return mesa;
	}
	
	@RequestMapping(value = "/deletaMesa/{id}")
	public boolean deletaMesa(@PathVariable long id) {
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
