package com.pruebaneoris.microservicios.app.prueba.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cliente;
import com.pruebaneoris.microservicios.app.prueba.models.repository.ClienteRepository;


@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

	@Override
	@Transactional(readOnly = true)
	public Cliente findByIdentificacion(String identificacion) {
		
		return repository.findByIdentificacion(identificacion);
	}

	
}
