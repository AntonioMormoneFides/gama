package com.project.gama.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.model.RegistroEntrateUsciteModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.repository.RegistroEntrateUsciteRepository;

import dtoClasses.BadgeDTO;
import dtoClasses.LogPassaggioDipendenteDTO;
import dtoClasses.TornelloDTO;

@Service
public class MainService {

	@Autowired
	RegistroEntrateUsciteRepository reur;
	@Autowired
	DipendenteRepository dr;
	@Autowired
	DipendenteRepository dipRepository;
	@Autowired
	MansioniLavorativeRepository mlRepository;

	public LogPassaggioDipendenteDTO passaggio(TornelloDTO tornello) {

		String numeroBadge = tornello.getNumeroBadge();
		LocalDate dataConvertita = tornello.getData();
		RegistroEntrateUsciteModel perEntrata = null;
		RegistroEntrateUsciteModel perUscita = null;	
		LogPassaggioDipendenteDTO mockLog = new LogPassaggioDipendenteDTO();
		
		try {
				DipendenteModel dm = dr.findByNumeroBadge(numeroBadge);
				RegistroEntrateUsciteModel mock = reur.findOneByDipendenteAndGiorno(dm, dataConvertita);
				if (mock == null) {
					perEntrata = reur.save(new RegistroEntrateUsciteModel(LocalTime.now(), null, dataConvertita, dm));
					mockLog = new LogPassaggioDipendenteDTO(dm.getNome(), dm.getCognome(), perEntrata.getEntrata(), null,
							dataConvertita);
				} else {

					perUscita = reur.save(new RegistroEntrateUsciteModel(mock.getId(), mock.getEntrata(), LocalTime.now(),
							dataConvertita, dm));
					mockLog = new LogPassaggioDipendenteDTO(dm.getNome(), dm.getCognome(), mock.getEntrata(),
							perUscita.getUscita(), dataConvertita);
				}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mockLog;
	}

	public LogPassaggioDipendenteDTO passaggioLeggi(TornelloDTO tornello) {

		String numeroBadge = tornello.getNumeroBadge();

		DipendenteModel dm = dr.findByNumeroBadge(numeroBadge);
		LocalDate dataConvertita = tornello.getData();
		LogPassaggioDipendenteDTO mockLog = new LogPassaggioDipendenteDTO();

		try {

			RegistroEntrateUsciteModel reg = reur.findOneByDipendenteAndGiorno(dm, dataConvertita);
			mockLog = new LogPassaggioDipendenteDTO(dm.getNome(), dm.getCognome(), reg.getEntrata(), reg.getUscita(),
					dataConvertita);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return mockLog;
	}

	public List<MansioniLavorativeModel> mostraMansioniDipendente(BadgeDTO numeroBadge) {
		
		DipendenteModel dipendenteTrovato = dipRepository.findByNumeroBadge(numeroBadge.getNumeroBadge());
		return mlRepository.findAllByDipendente(dipendenteTrovato);
	}

	public void cancellaByNumeroBadge(String numeroBadge) {
		dr.deleteByNumeroBadge(numeroBadge);
	}

	public List<DipendenteModel> elencaDipendenti() {
		return dipRepository.findAll();
	}

	public DipendenteModel cambiaBadge(String vecchioBadge, String nuovoBadge) {

		DipendenteModel old = dipRepository.findByNumeroBadge(vecchioBadge);
		DipendenteModel newB = dipRepository
				.save(new DipendenteModel(old.getIdDipendente(), old.getNome(), old.getCognome(), nuovoBadge));

		return newB;

	}

}
