package com.pruebaneoris.microservicios.app.prueba.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Cliente;
import com.pruebaneoris.microservicios.app.prueba.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends CommonController<Cliente, ClienteService> {

	@GetMapping("/findByIdentificacion/{identificacion}")
	public ResponseEntity<?> findByIdentificacion(@PathVariable String identificacion){
		Cliente cliBd =service.findByIdentificacion(identificacion);
		if(cliBd == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cliBd);
	}
	
	@PutMapping("/{numIdentificacion}")
	public ResponseEntity<?> editarCliente(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable String numIdentificacion){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Cliente cliBd = service.findByIdentificacion(numIdentificacion);
		
		if(cliBd == null) {
			return ResponseEntity.notFound().build();
		}
		
		cliBd.setNombre(cliente.getNombre());
		cliBd.setGenero(cliente.getGenero());
		cliBd.setEdad(cliente.getEdad());
		cliBd.setIdentificacion(cliente.getIdentificacion());
		cliBd.setTelefono(cliente.getTelefono());
		cliBd.setEstado(cliente.getEstado());
		cliBd.setContrasena(cliente.getContrasena());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cliBd));
	}
}
