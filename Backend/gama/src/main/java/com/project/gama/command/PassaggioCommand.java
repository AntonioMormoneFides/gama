package com.project.gama.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.repository.RegistroEntrateUsciteRepository;
import com.project.gama.service.MainService;

import dtoClasses.LogPassaggioDipendenteDTO;

@Component
public class PassaggioCommand {

	@Autowired RegistroEntrateUsciteRepository reup;
	@Autowired MainService ma;
	
	
	public PassaggioCommand() {
		
	}


	public RegistroEntrateUsciteRepository getReup() {
		return reup;
	}


	public void setReup(RegistroEntrateUsciteRepository reup) {
		this.reup = reup;
	}
	 
	

	
	
	
	
}