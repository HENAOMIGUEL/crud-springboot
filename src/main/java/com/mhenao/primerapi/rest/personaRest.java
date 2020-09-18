package com.mhenao.primerapi.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhenao.primerapi.service.PersonaService;
import com.mhenao.primerapi.vo.Persona;

@RestController
@RequestMapping("/api/persona/")
public class personaRest {

	@Autowired
	private PersonaService pesonaService;

	@PostMapping ("guardarPersona")
	private ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
		Persona personaTemporal = pesonaService.createPerson(persona);

		try {
			return ResponseEntity.created(new URI("/api/persona" + personaTemporal.getId()))
					.body(personaTemporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	/*************************************************************************************************************************
	 * *SE PUEDE TAMBIEN ASI, SIN USAR RESPONSE ENTITY , SOLO QUE TOCA USAR REQUESTMAPPING PA ESPECIFICAR QUE ME DEVUELVA UN JSON
	******************************************************************************************************************************/
	/*@RequestMapping(value = "/traerPersonas", method = RequestMethod.GET, produces = "application/json")
	private List<Persona> traerPersonas() {

		//ResponseEntity<List<Persona>> res = restTemplate.postForEntity(getUrl(), myDTO, new ParameterizedTypeReference<List<MyObj>>() {});

		return pesonaService.getAllPersonas();
		

	}*/
	
	@GetMapping ("traerPersonas")
	private ResponseEntity<List<Persona>> traerPersonas() {
		return ResponseEntity.ok(pesonaService.getAllPersonas());
	}
	
	@DeleteMapping ("borrarPersona/{id}")
	private ResponseEntity<Void> borrarPersona(@PathVariable(value = "id") Long id) {		
		pesonaService.deletePerson(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("traerPersonaById/{id}")
	private ResponseEntity<Optional<Persona>> traerPersonaById(@PathVariable(value = "id") Long id) {		
		return ResponseEntity.ok(pesonaService.findPersonById(id));
	}

}
