package com.pruebaneoris.microservicios.app.prueba.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	
	@Query("select p from Persona p where p.identificacion = ?1")
	public Persona findByIdentificacion(String identificacion);
}
