package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteService {
	
	 List<Cliente> findAll();

	 void save(Cliente cliente);
	
	 Cliente findOne(Long id);
	
	 void delete(Long id);

	 Cliente findOneWithQuery(Long id);

	 List<Cliente> findAllByIdRange(Long from, Long to);

	 List<Cliente> findAllByEmailContainingDomain(String domain);




}
