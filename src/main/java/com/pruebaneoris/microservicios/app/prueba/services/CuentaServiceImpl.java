package com.pruebaneoris.microservicios.app.prueba.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cuenta;
import com.pruebaneoris.microservicios.app.prueba.models.repository.CuentaRepository;

@Service
public class CuentaServiceImpl extends CommonServiceImpl<Cuenta, CuentaRepository> implements CuentaService {

	@Override
	@Transactional(readOnly = true)
	public Cuenta findByNumeroCuenta(String numCuenta) {
		
		return repository.findByNumeroCuenta(numCuenta);
	}
	

}
