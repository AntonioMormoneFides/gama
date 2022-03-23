package com.project.gama.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistroEntrateUsciteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private LocalTime entrata;
	
	
	
	private LocalTime uscita;
	
	
	private LocalDate giorno;
	
	
	public RegistroEntrateUsciteModel() {
		// TODO Auto-generated constructor stub
	}
	
}
