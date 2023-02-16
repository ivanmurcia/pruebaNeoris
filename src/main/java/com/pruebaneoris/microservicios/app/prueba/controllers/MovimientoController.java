package com.pruebaneoris.microservicios.app.prueba.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cuenta;
import com.pruebaneoris.microservicios.app.prueba.models.entity.Movimiento;
import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;
import com.pruebaneoris.microservicios.app.prueba.services.CuentaService;
import com.pruebaneoris.microservicios.app.prueba.services.MovimientoService;
import com.pruebaneoris.microservicios.app.prueba.services.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController extends CommonController<Movimiento, MovimientoService> {
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping("/{numCuenta}")
	public ResponseEntity<?> registerTransaction(@Valid @RequestBody Movimiento movimiento, BindingResult result, @PathVariable String numCuenta){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Cuenta cuenta = cuentaService.findByNumeroCuenta(numCuenta);
		
		if(cuenta == null) {
			return ResponseEntity.badRequest().body("Número de cuenta " + numCuenta + " no existe.");
		}else {
			System.out.println("numCuenta: "+numCuenta);
			System.out.println("Cuenta: "+cuenta.toString());
			System.out.println("La cuenta no es null");
		}
		
		BigDecimal resultadoOperacion = new BigDecimal(0);
		
		switch (movimiento.getTipoMovimiento().toUpperCase()) {
			case "DEBITO": 
			
				if(cuenta.getSaldoInicial().compareTo(BigDecimal.ZERO) == 0) {
					return ResponseEntity.badRequest().body("Saldo no disponible. ");
				}
				
				resultadoOperacion = cuenta.getSaldoInicial().subtract( movimiento.getValor()) ;
				if (resultadoOperacion.compareTo(BigDecimal.ZERO) < 0) {
					return ResponseEntity.badRequest().body("Saldo insuficiente. ");
				}
				
				cuenta.setSaldoInicial(resultadoOperacion);
				movimiento.setSaldo(resultadoOperacion);
				movimiento.setCuenta(cuenta);
				//movimiento.setCuenta(cuenta.getId());
				
				break;
		
			case "CREDITO": 
				
				resultadoOperacion = cuenta.getSaldoInicial().add(movimiento.getValor());
				
				cuenta.setSaldoInicial(resultadoOperacion);
				movimiento.setSaldo(resultadoOperacion);
				movimiento.setCuenta(cuenta);
				//movimiento.setCuenta(cuenta.getId());
				
				break;
				
			default:
				return ResponseEntity.badRequest().body("Movimiento " + movimiento.getTipoMovimiento() + " no permitido.");
		}
		
		
		Map<String, Object> procedimientos = new HashMap();
		procedimientos.put("Movimiento", service.save(movimiento));
		procedimientos.put("Cuenta", cuentaService.save(cuenta));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(procedimientos);
		
	}
	
	@GetMapping("/{numDocumentoCliente}/reportes")
	public ResponseEntity<?> reporteGeneral(@PathVariable String numDocumentoCliente, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicial, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFinal ) {
		
		Persona person = personaService.findByIdentificacion(numDocumentoCliente);
		
		if(person == null) {
			return ResponseEntity.badRequest().body("Cliente no existe. ");
		}
		
				
		List<Movimiento> movimientos = service.reporteByClienteByDate(numDocumentoCliente, fechaInicial, fechaFinal);
		
		return ResponseEntity.ok().body(movimientos);
		
	}

}
