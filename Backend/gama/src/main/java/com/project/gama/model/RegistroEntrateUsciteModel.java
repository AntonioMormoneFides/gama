package com.project.gama.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RegistroEntrateUsciteModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private LocalTime entrata;
	
	
	private LocalTime uscita;
	
	
	private LocalDate giorno;
	
	@ManyToOne
	@JoinColumn(name="idDipendente") 
	private DipendenteModel dipendente;	
	
	public RegistroEntrateUsciteModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
