package com.mhenao.primerapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhenao.primerapi.vo.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Long>{

}
