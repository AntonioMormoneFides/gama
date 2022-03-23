package com.project.gama.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.model.DipendenteModel;
import com.project.gama.repository.DipendenteRepository;

@RestController
public class GamaController {
	
	@Autowired
	private  DipendenteRepository repository;
	
	@GetMapping("/")
	public DipendenteModel test() {
			
		return repository.save(new DipendenteModel("toto", "peppino", "la mala femmina"));
		
	}

	
	
	

}
