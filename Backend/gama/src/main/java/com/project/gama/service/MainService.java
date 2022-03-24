package com.project.gama.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;

@Service
public class MainService {
	
	@Autowired
	private  DipendenteRepository dipRepository;
	@Autowired
	private  MansioniLavorativeRepository mlRepository;
	
	
	public List<MansioniLavorativeModel> mostraMansioniDipendente (String numeroBadge) {		
		DipendenteModel dipendenteTrovato = dipRepository.findByNumeroBadge(numeroBadge);		
		return mlRepository.findAllByDipendente(dipendenteTrovato.getIdDipendente());		
		}
	
	
	
	

	
	
	

}
