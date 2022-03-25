package com.project.gama.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.model.DipendenteModel;
import com.project.gama.service.MainService;

@Component
public class MostraDipendentiCommand {
	
	@Autowired
	private MainService ma;
	
	public MostraDipendentiCommand() {
		super();
	}

	public MainService getMa() {
		return ma;
	}

	public void setMa(MainService ma) {
		this.ma = ma;
	}

	public List<DipendenteModel> elencaTuttiDipendenti() {
		return ma.elencaDipendenti();
	}

}
