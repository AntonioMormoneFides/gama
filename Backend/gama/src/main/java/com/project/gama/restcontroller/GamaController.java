package com.project.gama.restcontroller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gama.command.CancellaDipendenteCommand;
import com.project.gama.command.ElencaMansioniCommand;
import com.project.gama.command.MostraDipendentiCommand;
import com.project.gama.command.PassaggioBadgeCommand;
import com.project.gama.command.PassaggioCommand;
import com.project.gama.command.PassaggioCommandLeggi;
import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;

import dtoClasses.BadgeDTO;
import dtoClasses.LogPassaggioDipendenteDTO;
import dtoClasses.TornelloDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GamaController {

	@Autowired
	private DipendenteRepository dipRepository;

	@Autowired
	private MansioniLavorativeRepository mlr;

	@Autowired
	private PassaggioCommand pc;

	@Autowired
	private ElencaMansioniCommand command;

	@Autowired
	private CancellaDipendenteCommand cd;

	@Autowired
	private MostraDipendentiCommand md;
	@Autowired
	private PassaggioBadgeCommand pbc;

	@Autowired
	private PassaggioCommandLeggi pcl;

	@GetMapping("/test1")
	public void testTabellaDipendente() {
		dipRepository.save(new DipendenteModel("Gianni", "Fappucchioni", "98754gg"));

	}

	@GetMapping("/test2")
	public void testTabellaMansioniLavorative() {
		mlr.save(new MansioniLavorativeModel(dipRepository.findByNumeroBadge("98754gg"), "Junior Developer",
				"Gama project", true, true));
	}

	@Transactional
	@GetMapping("/test3") // pulizia tabella mansioni lavorative
	public void cancellaById(@RequestParam("id") Long id) {
		mlr.deleteById(id);
	}

	@GetMapping("/mostradipendenti")
	public List<DipendenteModel> elencaDipendenti() {
		return md.elencaTuttiDipendenti();
	}

	@Transactional
	@PostMapping("/cancelladipendente")
	public String cancellaDipendente(@RequestParam("numeroBadge") String numeroBadge) {

		cd.licenziaDipendenteByNumeroBadge(numeroBadge);
		return "Dipendente cancellato";

	}

	@Transactional
	@PostMapping("/registro/scrivi")
	public LogPassaggioDipendenteDTO passaggioTornelloScrivi(@RequestBody TornelloDTO tornello) {

		return pc.doStuff(tornello);

	}

	@Transactional
	@PostMapping("/registro/leggi")
	public LogPassaggioDipendenteDTO passaggioTornelloLeggi(@RequestBody TornelloDTO tornello) {

		return pcl.doStuff(tornello);

	}

	@Transactional
	@PostMapping("/cambioBadge")
	public DipendenteModel passaggioBadge(@RequestParam("numeroVecchioBadge") String numeroVecchioBadge,
			@RequestParam("numeroNuovoBadge") String numeroNuovoBadge) {

		return pbc.doStuff(numeroVecchioBadge, numeroNuovoBadge);

	}

	@Transactional
	@PostMapping("/mostradipendentimansioni")
	public List<MansioniLavorativeModel> elencaMansioni(@RequestBody BadgeDTO numeroBadge) {

		System.out.println(numeroBadge);
		
		return command.elencaMansioniDipendente(numeroBadge);

	}

}
