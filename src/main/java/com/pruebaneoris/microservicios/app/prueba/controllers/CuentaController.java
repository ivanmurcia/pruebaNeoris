package com.pruebaneoris.microservicios.app.prueba.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cuenta;
import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;
import com.pruebaneoris.microservicios.app.prueba.services.CuentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuentas")
public class CuentaController extends CommonController<Cuenta, CuentaService> {

	
	@PutMapping("/{numCuenta}")
	public ResponseEntity<?> editarCuenta(@Valid @RequestBody Cuenta cuenta, BindingResult result, @PathVariable String numCuenta){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Cuenta cu = service.findByNumeroCuenta(numCuenta);
		
		if(cu == null) {
			return ResponseEntity.notFound().build();
		}
		
		Cuenta cuentaDb = cu;
		cuentaDb.setEstado(cuenta.getEstado());
		cuentaDb.setTipoCuenta(cuenta.getTipoCuenta());
		cuentaDb.setCliente(cuenta.getCliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaDb));
	}
	
}
