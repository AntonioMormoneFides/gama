package com.project.gama.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DipendenteModel {
	
	public DipendenteModel() {
	
	}

	public DipendenteModel(String nome, String cognome, String numeroBadge) {				
		this.nome = nome;
		this.cognome = cognome;
		this.numeroBadge = numeroBadge;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDipendente")
	private Integer idDipendente;
	
	private String nome;
	
	private String cognome;
	
	private String numeroBadge;
	
	@OneToMany(mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <RegistroEntrateUsciteModel> registro;
	
	@OneToMany(mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <MansioniLavorativeModel> mansioni;
	
	@OneToMany(mappedBy="dipendente", cascade= CascadeType.ALL)
	private Set <CurriculumModel> curricula;
	

	public Integer getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(Integer id) {
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
