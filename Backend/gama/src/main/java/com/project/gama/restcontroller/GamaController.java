package com.project.gama.restcontroller;

import java.time.LocalDate;
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
	
	@GetMapping("/mostradipendenti")
	public List<DipendenteModel> elencaDipendenti() {
		return repository.findAll();
	} 
	
	@PostMapping("/cancelladipendente")
	public List<DipendenteModel> cancellaDipendente(String numeroBadge) {
		return repository.deleteByNumeroBadge(numeroBadge);		
	}

	@PostMapping("/registro")
	public LogPassaggioDipendenteDTO passaggio(@RequestParam("numeroBadge") String numeroBadge, @RequestParam("data") LocalDate data ) {
		
		
		
		return null;
	}
	
	
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggio(@RequestParam("numeroVecchioBadge") String numeroVecchioBadge, @RequestParam("numeroNuovoBadge") String numeroNuovoBadge ) {
		
		
	
		return null;
	}
	
	
	

}
