package com.project.gama.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.model.MansioniLavorativeModel;
import com.project.gama.repository.DipendenteRepository;
import com.project.gama.repository.MansioniLavorativeRepository;
import com.project.gama.service.MainService;

@Component
public class ElencaMansioniCommand {
	
	@Autowired
	private  DipendenteRepository dipRepository;
	@Autowired
	private  MansioniLavorativeRepository mlRepository;
	@Autowired
	private MainService ma;
	
	public ElencaMansioniCommand() {
		
	}
	
	
	
	public DipendenteRepository getDipRepository() {
		return dipRepository;
	}



	public void setDipRepository(DipendenteRepository dipRepository) {
		this.dipRepository = dipRepository;
	}



	public MansioniLavorativeRepository getMlRepository() {
		return mlRepository;
	}



	public void setMlRepository(MansioniLavorativeRepository mlRepository) {
		this.mlRepository = mlRepository;
	}



	public MainService getMa() {
		return ma;
	}



	public void setMa(MainService ma) {
		this.ma = ma;
	}



	public List<MansioniLavorativeModel> elencaMansioniDipendente(String numeroBadge) {
		return ma.mostraMansioniDipendente(numeroBadge);
	}
	
	
	
	

}
