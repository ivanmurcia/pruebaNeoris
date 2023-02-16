package com.pruebaneoris.microservicios.app.prueba.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	@Query("select p from Persona p where p.identificacion = ?1")
	public Cliente findByIdentificacion(String identificacion);
}
