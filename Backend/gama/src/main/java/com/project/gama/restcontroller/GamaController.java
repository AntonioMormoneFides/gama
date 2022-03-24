package com.project.gama.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.model.DipendenteModel;
import com.project.gama.repository.DipendenteRepository;

import dtoClasses.LogPassaggioDipendenteDTO;

@RestController
public class GamaController {
	
	@Autowired
	private  DipendenteRepository repository;
	
	@GetMapping("/")
	public DipendenteModel test() {			
		return repository.save(new DipendenteModel("toto", "peppino", "la mala femmina"));		
	}
	
	@GetMapping("/alldipendenti")
	public List<DipendenteModel> elencaDipendenti() {
		return repository.findAll();
	} 

	@PostMapping("/registro")
	public LogPassaggioDipendenteDTO passaggio(@RequestParam("numeroBadge") String numeroBadge) {
		
		
		
		return null;
	}
	
	
	@GetMapping("/cambioBadge")
	public List<DipendenteModel> passaggio() {
		
		
		
		return null;
	}
	
	
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggio(@RequestParam("numeroBadge") String numeroBadge, @RequestParam("id") int id) {
		
		
	
		return null;
	}
	
	
	

}
