package com.project.gama.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DipendenteModel {
	
	public DipendenteModel(Long idDipendente, String nome, String cognome, String numeroBadge) {
		super();
		this.idDipendente = idDipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroBadge = numeroBadge;
	}

	public DipendenteModel() {
	
	}

	public DipendenteModel(String nome, String cognome, String numeroBadge) {				
		this.nome = nome;
		this.cognome = cognome;
		this.numeroBadge = numeroBadge;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idDipendente;
	
	private String nome;
	
	private String cognome;
	
	private String numeroBadge;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <RegistroEntrateUsciteModel> registro;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <MansioniLavorativeModel> mansioni;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <CurriculumModel> curricula;
	

	public Long getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(Long id) {
		this.idDipendente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumeroBadge() {
		return numeroBadge;
	}

	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
	}
	
	
	         

}
