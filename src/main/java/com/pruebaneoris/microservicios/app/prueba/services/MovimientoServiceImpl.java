package com.pruebaneoris.microservicios.app.prueba.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Movimiento;
import com.pruebaneoris.microservicios.app.prueba.models.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl extends CommonServiceImpl<Movimiento, MovimientoRepository> implements MovimientoService {

	@Override
	public List<Movimiento> reporteByClienteByDate(String docuCliente, Date fechaInicial, Date fechaFinal) {
		
		return repository.reporteByClienteByDate(docuCliente, fechaInicial, fechaFinal);
	}

}
