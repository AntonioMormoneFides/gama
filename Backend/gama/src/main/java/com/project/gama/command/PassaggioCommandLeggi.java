package com.project.gama.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.repository.RegistroEntrateUsciteRepository;
import com.project.gama.service.MainService;

import dtoClasses.LogPassaggioDipendenteDTO;

@Component
public class PassaggioCommandLeggi {

	
	@Autowired RegistroEntrateUsciteRepository reup;
	@Autowired MainService ma;
	public RegistroEntrateUsciteRepository getReup() {
		return reup;
	}
	public void setReup(RegistroEntrateUsciteRepository reup) {
		this.reup = reup;
	}
	public MainService getMa() {
		return ma;
	}
	public void setMa(MainService ma) {
		this.ma = ma;
	}
	public PassaggioCommandLeggi(RegistroEntrateUsciteRepository reup, MainService ma) {
		super();
		this.reup = reup;
		this.ma = ma;
	}
	
	public PassaggioCommandLeggi() {
	
	}
	
	public LogPassaggioDipendenteDTO doStuff(String numeroBadge, String data) {
		
		return ma.passaggioLeggi(numeroBadge, data);
	}
}
