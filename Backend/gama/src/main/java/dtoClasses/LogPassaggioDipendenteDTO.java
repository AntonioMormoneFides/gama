package dtoClasses;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogPassaggioDipendenteDTO {

	private String nome;
	private String cognome;
	private LocalTime orarioEntrata;
	private LocalTime orarioUscita;
	private LocalDate data;

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

	public LocalTime getOrarioEntrata() {
		return orarioEntrata;
	}
	public void setOrarioEntrata(LocalTime orarioEntrata) {
		this.orarioEntrata = orarioEntrata;
	}
	public LocalTime getOrarioUscita() {
		return orarioUscita;
	}
	public void setOrarioUscita(LocalTime orarioUscita) {
		this.orarioUscita = orarioUscita;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	
	public LogPassaggioDipendenteDTO(String nome, String cognome, LocalTime orarioEntrata, LocalTime orarioUscita,
			LocalDate data) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.orarioEntrata = orarioEntrata;
		this.orarioUscita = orarioUscita;
		this.data = data;
		
	}
	
	
	public LogPassaggioDipendenteDTO() {
		
	};
	
}
