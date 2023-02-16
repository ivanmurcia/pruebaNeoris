package com.pruebaneoris.microservicios.app.prueba.models.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

	@Query("select m from Movimiento m join fetch m.cuenta cu join fetch cu.cliente c where c.identificacion = ?1 AND m.fecha between ?2 AND ?3 ")
	public List<Movimiento> reporteByClienteByDate(String docuCliente, Date fechaInicial, Date fechaFinal);
}
