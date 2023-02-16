package com.pruebaneoris.microservicios.app.prueba.services;

import java.util.Date;
import java.util.List;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Movimiento;

public interface MovimientoService extends CommonService<Movimiento> {

	public List<Movimiento> reporteByClienteByDate(String docuCliente, Date fechaInicial, Date fechaFinal);
	
}
