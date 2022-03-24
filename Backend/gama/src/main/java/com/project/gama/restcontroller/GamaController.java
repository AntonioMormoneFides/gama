package com.project.gama.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.command.ElencaMansioniCommand;
import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.service.MainService;

import dtoClasses.LogPassaggioDipendenteDTO;

@RestController
public class GamaController {
	
	@Autowired
	private  DipendenteRepository dipRepository;
	@Autowired
	private  MansioniLavorativeRepository mlRepository;
	@Autowired
	private ElencaMansioniCommand command;
	@Autowired
	private MainService ma;
	
	@GetMapping("/")
	public DipendenteModel test() {			
		return dipRepository.save(new DipendenteModel("toto", "peppino", "la mala femmina"));		
	}
	
	@GetMapping("/mostradipendenti")
	public List<DipendenteModel> elencaDipendenti() {
		return dipRepository.findAll();
	} 
	
	@PostMapping("/cancelladipendente")
	public DipendenteModel cancellaDipendente(@RequestParam("numeroBadge") String numeroBadge) {
		return dipRepository.deleteByNumeroBadge(numeroBadge);		
	}

	@PostMapping("/registro")
	public LogPassaggioDipendenteDTO passaggio(@RequestParam("numeroBadge") String numeroBadge, @RequestParam("data") LocalDate data ) {
		
		
		
		return null;
	}
	
	
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggio(@RequestParam("numeroVecchioBadge") String numeroVecchioBadge, @RequestParam("numeroNuovoBadge") String numeroNuovoBadge ) {
		
		
	
		return null;
	}
	
	
	@PostMapping("/mostradipendentimansioni")
	public List<MansioniLavorativeModel> elencaMansioni(@RequestParam("numeroBadge") String numeroBadge) {		

		return command.elencaMansioniDipendente(numeroBadge);
	
	} 
	
	
	

}
