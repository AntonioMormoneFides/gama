package com.project.gama.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gama.model.DipendenteModel;
import com.project.gama.service.MainService;

@Component
public class PassaggioBadgeCommand {

	
	@Autowired
	MainService ma;
	
	public DipendenteModel doStuff(String vecchioBadge, String nuovoBadge){
		
		return ma.cambiaBadge(vecchioBadge, nuovoBadge);
		
		
	}
	
	
}
