package com.project.gama.restcontroller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.command.ElencaMansioniCommand;
import com.project.gama.command.PassaggioCommand;
import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.repository.CurriculumRepository;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.repository.RegistroEntrateUsciteRepository;

import dtoClasses.LogPassaggioDipendenteDTO;

@RestController
public class GamaController {
	
	@Autowired
	private  DipendenteRepository dipRepository;
	@Autowired
	private CurriculumRepository cr;
	
	@Autowired
	private MansioniLavorativeRepository mlr;
	
	@Autowired 
	private RegistroEntrateUsciteRepository reur;
	
	@Autowired 
	private PassaggioCommand pc;
	
	@Autowired 
	private ElencaMansioniCommand command;
	
	@GetMapping("/")
	public void test() {			
		 DipendenteModel dmIn = dipRepository.save(new DipendenteModel("Giovanni", "Mario", "Giovanni"));
		
	}

    @GetMapping("/test2")
    public void testTabellaMansioniLavorative() {
        MansioniLavorativeModel dmIn = mlr.save(new MansioniLavorativeModel(dipRepository.findByNumeroBadge("Giovanni"), "Junior Developer", "Gama project", true , true ));
    }
	
	@GetMapping("/mostradipendenti")
	public List<DipendenteModel> elencaDipendenti() {
		return dipRepository.findAll();
	} 
	
	@Transactional
	@PostMapping("/cancelladipendente")
	public DipendenteModel cancellaDipendente(@RequestParam("numeroBadge") String numeroBadge) {
		
		System.out.println("ci sono quasi");
		
		DipendenteModel daCancellare = dipRepository.findByNumeroBadge(numeroBadge);
		
		dipRepository.deleteByNumeroBadge(numeroBadge);
		
		return daCancellare;
		
//		dipRepository.deleteAll();
//		
//		return new DipendenteModel();
	}
	
	
	@Transactional
	@PostMapping("/registro")
	public LogPassaggioDipendenteDTO passaggioTornello(@RequestParam("numeroBadge") String numeroBadge, @RequestParam("data") String data ) {
		
		return pc.doStuff(numeroBadge, data);
	
	}
	
	@Transactional
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggio(@RequestParam("numeroVecchioBadge") String numeroVecchioBadge, @RequestParam("numeroNuovoBadge") String numeroNuovoBadge ) {
		
		
	
		return null;
	}
	
	@Transactional
	@PostMapping("/mostradipendentimansioni")
	public List<MansioniLavorativeModel> elencaMansioni(@RequestParam("numeroBadge") String numeroBadge) {		

		System.out.println(numeroBadge);
		
		return command.elencaMansioniDipendente(numeroBadge);
	
	} 
	
	
	

}
