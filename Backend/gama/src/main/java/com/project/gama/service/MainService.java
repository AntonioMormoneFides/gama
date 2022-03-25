package com.project.gama.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.model.RegistroEntrateUsciteModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.repository.RegistroEntrateUsciteRepository;

import dtoClasses.LogPassaggioDipendenteDTO;

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
	
	
	public LogPassaggioDipendenteDTO passaggio(String numeroBadge, String data) {
		
		DipendenteModel dm = dr.findByNumeroBadge(numeroBadge);
		LocalDate dataConvertita = LocalDate.parse(data);
		RegistroEntrateUsciteModel mock = reur.findOneByDipendenteAndGiorno(dm, dataConvertita);
		
		RegistroEntrateUsciteModel perEntrata = null;
		RegistroEntrateUsciteModel perUscita = null;
		
		LogPassaggioDipendenteDTO mockLog = null;
		
		
		if(mock == null) {
			perEntrata = reur.save(new RegistroEntrateUsciteModel(LocalTime.now(), null, dataConvertita, dm));
			mockLog = new LogPassaggioDipendenteDTO(dm.getNome(), dm.getCognome(), perEntrata.getEntrata(), null, dataConvertita);
		} else {
			
			perUscita  = reur.save(new RegistroEntrateUsciteModel(mock.getId(), mock.getEntrata(), LocalTime.now(), dataConvertita, dm));
			mockLog = new LogPassaggioDipendenteDTO(dm.getNome(), dm.getCognome(), mock.getEntrata(), perUscita.getUscita(), dataConvertita);
		}
		
		return mockLog;
	}
	
	
	public List<MansioniLavorativeModel> mostraMansioniDipendente (String numeroBadge) {		
		DipendenteModel dipendenteTrovato = dipRepository.findByNumeroBadge(numeroBadge);		
		return mlRepository.findAllByDipendente(dipendenteTrovato);
		return mlRepository.findAllByDipendente(dipendenteTrovato);		
		}
	
	
	public DipendenteModel cambiaBadge(String vecchioBadge, String nuovoBadge){
		
		
		DipendenteModel old = dipRepository.findByNumeroBadge(vecchioBadge);
		DipendenteModel newB = dipRepository.save(new DipendenteModel(old.getIdDipendente(), old.getNome(), old.getCognome(), nuovoBadge));
		
	
		
		
		return newB;
		
		
	}
	

	
	
	

}
