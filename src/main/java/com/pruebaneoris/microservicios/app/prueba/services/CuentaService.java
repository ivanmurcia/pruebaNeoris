package com.pruebaneoris.microservicios.app.prueba.services;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cuenta;

public interface CuentaService extends CommonService<Cuenta> {
	
	public Cuenta findByNumeroCuenta(String numCuenta);
}
