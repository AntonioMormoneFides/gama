package com.project.gama.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.command.PassaggioCommand;
import com.project.gama.model.DipendenteModel;
import com.project.gama.model.RegistroEntrateUsciteModel;
import com.project.gama.repository.CurriculumRepository;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.repository.RegistroEntrateUsciteRepository;

import dtoClasses.LogPassaggioDipendenteDTO;

@RestController
public class GamaController {
	
	@Autowired
	private  DipendenteRepository repository;
	@Autowired
	private CurriculumRepository cr;
	
	@Autowired
	private MansioniLavorativeRepository mlr;
	
	@Autowired 
	private RegistroEntrateUsciteRepository reur;
	
	@Autowired 
	private PassaggioCommand pc;
	
	@GetMapping("/")
	public void test() {			
		 DipendenteModel dmIn = repository.save(new DipendenteModel("Gianni", "Fappucchioni", "98754gg"));
		
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
	public LogPassaggioDipendenteDTO passaggioTornello(@RequestParam("numeroBadge") String numeroBadge, @RequestParam("data") String data ) {
		
		return pc.doStuff(numeroBadge, data);
	
	}
	
	
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggio(@RequestParam("numeroVecchioBadge") String numeroVecchioBadge, @RequestParam("numeroNuovoBadge") String numeroNuovoBadge ) {
		
		
	
		return null;
	}
	
	
	

}
