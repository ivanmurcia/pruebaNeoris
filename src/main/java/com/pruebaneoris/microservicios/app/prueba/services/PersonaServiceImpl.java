package com.pruebaneoris.microservicios.app.prueba.services;

import org.springframework.stereotype.Service;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;
import com.pruebaneoris.microservicios.app.prueba.models.repository.PersonaRepository;

@Service
public class PersonaServiceImpl extends CommonServiceImpl<Persona, PersonaRepository> implements PersonaService {

	@Override
	public Persona findByIdentificacion(String identificacion) {
		
		return repository.findByIdentificacion(identificacion);
	}
	

}
