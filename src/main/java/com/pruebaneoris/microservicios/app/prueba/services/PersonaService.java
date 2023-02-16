package com.pruebaneoris.microservicios.app.prueba.services;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;

public interface PersonaService extends CommonService<Persona> {

	public Persona findByIdentificacion(String identificacion);
	
}
