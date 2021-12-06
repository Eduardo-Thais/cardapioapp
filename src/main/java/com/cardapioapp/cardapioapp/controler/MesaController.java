package com.cardapioapp.cardapioapp.controler;

import java.io.ByteArrayOutputStream;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:8080")
public class MesaController {
	
	
	
	@Autowired
	private MesaRepository mr;
	
	@RequestMapping(value = "/cadastrarMesa", method = RequestMethod.POST)
	public boolean cadastrarMesa(@RequestBody Mesa cadastro) throws Exception{
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		
		BitMatrix matrix = new MultiFormatWriter().encode(cadastro.getNome(), BarcodeFormat.QR_CODE, 500, 500);
		MatrixToImageWriter.writeToStream(matrix, "jpg", out);
		
		byte[] pngData = out.toByteArray();
		
		cadastro.setQrcode(pngData);
		
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
