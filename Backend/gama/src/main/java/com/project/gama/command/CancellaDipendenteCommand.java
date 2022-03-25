package com.project.gama.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.repository.DipendenteRepository;
import com.project.gama.service.MainService;

@Component
public class CancellaDipendenteCommand {
	
	CancellaDipendenteCommand () {
		
	}
	
	@Autowired DipendenteRepository dr;
	@Autowired MainService ma;
	public MainService getMa() {
		return ma;
	}
	public void setMa(MainService ma) {
		this.ma = ma;
	}
	public DipendenteRepository getDr() {
		return dr;
	}
	public void setDr(DipendenteRepository dr) {
		this.dr = dr;
	}
	
	public void licenziaDipendenteByNumeroBadge(String numeroBadge) {
		ma.cancellaByNumeroBadge(numeroBadge);
	}

	

}
