package com.project.gama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CurriculumModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@ManyToOne
	@JoinColumn(name="idDipendente") 
	private DipendenteModel dipendente;	
		
	@Column//"varchar(max)"		
	private String esperienzeStudio;
	
	@Column
	private String esperienzeLavoro;
	
	@Column
	private String autodescrizione;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEsperienzeStudio() {
		return esperienzeStudio;
	}
	public void setEsperienzeStudio(String esperienzeStudio) {
		this.esperienzeStudio = esperienzeStudio;
	}
	public String getEsperienzeLavoro() {
		return esperienzeLavoro;
	}
	public void setEsperienzeLavoro(String esperienzeLavoro) {
		this.esperienzeLavoro = esperienzeLavoro;
	}
	public String getAutodescrizione() {
		return autodescrizione;
	}
	public void setAutodescrizione(String autodescrizione) {
		this.autodescrizione = autodescrizione;
	}
	public CurriculumModel(Integer id,  String esperienzeStudio, String esperienzeLavoro,
			String autodescrizione) {
		super();
		this.id = id;
		
		this.esperienzeStudio = esperienzeStudio;
		this.esperienzeLavoro = esperienzeLavoro;
		this.autodescrizione = autodescrizione;
	}
	
	
	public CurriculumModel() {
		
	};
	
}
