package com.project.gama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MansioniLavorativeModel {
	
	public MansioniLavorativeModel() {
		
	}
	
	public MansioniLavorativeModel(Long id, String ruolo, String progetto, boolean tipoContratto,
			boolean statoLavorativo) {
		this.id= id;	
		this.ruolo = ruolo;
		this.progetto = progetto;
		this.tipoContratto = tipoContratto;
		this.statoLavorativo = statoLavorativo;
	}
	
	public MansioniLavorativeModel( DipendenteModel idDipendente, String ruolo, String progetto, boolean tipoContratto,
			boolean statoLavorativo) {
			
		this.ruolo = ruolo;
		this.progetto = progetto;
		this.tipoContratto = tipoContratto;
		this.statoLavorativo = statoLavorativo;
	}
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idDipendente") 
	private DipendenteModel dipendente;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String ruolo;
	
	private String progetto;
	
	private boolean tipoContratto; //FULL TIME= TRUE, PART TIME=FALSE
	
	private boolean statoLavorativo; //IMPIEGATO= TRUE, LICENZIATO=FALSE

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getProgetto() {
		return progetto;
	}

	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}

	public boolean isTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(boolean tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	public boolean isStatoLavorativo() {
		return statoLavorativo;
	}

	public void setStatoLavorativo(boolean statoLavorativo) {
		this.statoLavorativo = statoLavorativo;
	}

	public DipendenteModel getDipendente() {
		return dipendente;
	}

	public void setDipendente(DipendenteModel dipendente) {
		this.dipendente = dipendente;
	}
	
	
	

}
