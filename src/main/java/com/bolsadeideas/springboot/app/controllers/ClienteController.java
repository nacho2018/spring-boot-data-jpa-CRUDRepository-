package com.bolsadeideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.bolsadeideas.springboot.app.models.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IFacturaService facturaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Cliente> listar() {

		return clienteService.findAll();

	}
	
	@RequestMapping(value = "/save")
	public ResponseEntity<String> crear(@RequestBody Cliente client) {

		clienteService.save(client);

		return ResponseEntity.ok("Client created");
	}
	
	@RequestMapping(value="/edit")
	public  ResponseEntity<String> editar(@RequestBody Cliente client) {
		
		Cliente storedClient;
		
		if(client.getId() > 0) {
			storedClient = clienteService.findOne(client.getId());
		} else {
			return ResponseEntity.badRequest().body("Id must be equal or greater than zero.");
		}
		storedClient.setNombre(client.getNombre());
		storedClient.setApellido(client.getApellido());
		storedClient.setCreateAt(client.getCreateAt());
		storedClient.setEmail(client.getEmail());
		clienteService.save(storedClient);
		return  ResponseEntity.ok("Client updatded");
	}
	

	
	@RequestMapping(value="/delete/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteService.delete(id);
			return ResponseEntity.ok("Client deleted");
		}
		return ResponseEntity.badRequest().body("Id must be greater or equals than zero");
	}

	@RequestMapping(value = "/findById/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable(name = "id")  Long id){

		if (id < 0)
			return ResponseEntity.badRequest().body(null);

		return ResponseEntity.ok(this.clienteService.findOneWithQuery(id));
	}

	@RequestMapping(value = "/finAllByIdRange/{from}/{to}")
	public ResponseEntity<List<Cliente>> findAllByIdRange(@PathVariable(name="from") Long from, @PathVariable(name = "to") Long to){
		if (from < 0 || to < 0 || from > to)
			return ResponseEntity.badRequest().body(null);

		return ResponseEntity.ok().body(clienteService.findAllByIdRange(from, to));
	}

	@RequestMapping(value = "/findAllByEmailContainingDomain/{domain}")
	public ResponseEntity<List<Cliente>> findAllByEmailContainingDomain(@PathVariable(name="domain") String domain){
		return ResponseEntity.ok().body(clienteService.findAllByEmailContainingDomain(domain));
	}

	@RequestMapping(value="/findBillsByClient")
	public ResponseEntity<List<Factura>> findAllBillsByClient(@RequestBody Cliente client){

		if (client == null || client.getId() == null || client.getId() < 0)
			return ResponseEntity.badRequest().body(null);

		Cliente savedClient = clienteService.findOne(client.getId());
		if (savedClient == null)
			return ResponseEntity.ok(new ArrayList<>());

		return ResponseEntity.ok(savedClient.getFacturas());

	}

	@RequestMapping(value="/findAllItemsByBill", method=RequestMethod.POST)
	public ResponseEntity<List<ItemFactura>> findAllItemsByBill(@RequestBody Factura bill){

		if (bill == null || bill.getId() == null || bill.getId() < 0)
			return ResponseEntity.badRequest().body(null);

		return  ResponseEntity.ok(facturaService.findAllItemsByBill(bill));
	}

}