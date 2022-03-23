package dtoClasses;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogPassaggioDipendenteDTO {

	private String nome;
	private String cognome;
	private LocalTime orario;
	private LocalDate data;
	private boolean entrato = false;
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
	public LocalTime getOrario() {
		return orario;
	}
	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public boolean isEntrato() {
		return entrato;
	}
	public void setEntrato(boolean entrato) {
		this.entrato = entrato;
	}
	public LogPassaggioDipendenteDTO(String nome, String cognome, LocalTime orario, LocalDate data, boolean entrato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.orario = orario;
		this.data = data;
		this.entrato = entrato;
	}
	
	public LogPassaggioDipendenteDTO() {
		
	};
	
}
