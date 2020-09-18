package com.mhenao.primerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhenao.primerapi.repo.PersonaRepo;
import com.mhenao.primerapi.vo.Persona;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepo miPersonaRepo;
	
	
	public Persona createPerson(Persona persona) {
		return miPersonaRepo.save(persona);
	}
	
	public List<Persona> getAllPersonas(){
		return miPersonaRepo.findAll();
	}
	
	public void deletePerson(Long id){
		 miPersonaRepo.deleteById(id);
	}
	
	public Optional<Persona> findPersonById(Long id) {
		return miPersonaRepo.findById(id);
	}
	
}
