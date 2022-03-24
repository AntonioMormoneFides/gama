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
	private Long id;
	
	
	private LocalTime entrata;
	
	
	
	
	
	
	public RegistroEntrateUsciteModel( LocalTime entrata, LocalTime uscita, LocalDate giorno,
			DipendenteModel dipendente) {
		super();
		
		this.entrata = entrata;
		this.uscita = uscita;
		this.giorno = giorno;
		this.dipendente = dipendente;
	}



	public RegistroEntrateUsciteModel(Long id, LocalTime entrata, LocalTime uscita, LocalDate giorno,
			DipendenteModel dipendente) {
		super();
		this.id = id;
		this.entrata = entrata;
		this.uscita = uscita;
		this.giorno = giorno;
		this.dipendente = dipendente;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalTime getEntrata() {
		return entrata;
	}

	public void setEntrata(LocalTime entrata) {
		this.entrata = entrata;
	}

	public LocalTime getUscita() {
		return uscita;
	}

	public void setUscita(LocalTime uscita) {
		this.uscita = uscita;
	}

	public LocalDate getGiorno() {
		return giorno;
	}

	public void setGiorno(LocalDate giorno) {
		this.giorno = giorno;
	}

	public DipendenteModel getDipendente() {
		return dipendente;
	}

	public void setDipendente(DipendenteModel dipendente) {
		this.dipendente = dipendente;
	}

	private LocalTime uscita;
	
	
	private LocalDate giorno;
	
	@ManyToOne
	@JoinColumn(name="idDipendente") 
	private DipendenteModel dipendente;	
	
	public RegistroEntrateUsciteModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
