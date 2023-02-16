package com.pruebaneoris.microservicios.app.prueba.services;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cliente;

public interface ClienteService extends CommonService<Cliente> {

	public Cliente findByIdentificacion(String identificacion);
}
