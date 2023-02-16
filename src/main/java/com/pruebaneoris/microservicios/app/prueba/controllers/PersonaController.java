package com.pruebaneoris.microservicios.app.prueba.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaneoris.microservicios.app.prueba.models.entity.Persona;
import com.pruebaneoris.microservicios.app.prueba.services.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaController extends CommonController<Persona, PersonaService> {

	
	@PutMapping("/{numIdentificacion}")
	public ResponseEntity<?> editarPersona(@Valid @RequestBody Persona persona, BindingResult result, @PathVariable String numIdentificacion){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Persona persoBd = service.findByIdentificacion(numIdentificacion);
		
		if(persoBd == null) {
			return ResponseEntity.notFound().build();
		}
		
		persoBd.setNombre(persona.getNombre());
		persoBd.setGenero(persona.getGenero());
		persoBd.setEdad(persona.getEdad());
		persoBd.setIdentificacion(persona.getIdentificacion());
		persoBd.setTelefono(persona.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(persoBd));
	}
	
}
