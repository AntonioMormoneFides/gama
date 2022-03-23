package com.project.gama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.gama.repository.DipendenteRepository;

@Controller
public class DipendenteController {
	
	@Autowired
	private  DipendenteRepository repository;

	public DipendenteController(DipendenteRepository repository) {
		super();
		this.repository = repository;
	}
	
	

}
