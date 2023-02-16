package com.pruebaneoris.microservicios.app.prueba.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

	@Query("select c from Cuenta c WHERE c.numeroCuenta = ?1")
	public Cuenta findByNumeroCuenta(String numCuenta);
}
