package dtoClasses;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;



public class TornelloDTO {

	
	String numeroBadge;
	LocalDate data;
	public String getNumeroBadge() {
		return numeroBadge;
	}
	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public TornelloDTO(String numeroBadge, LocalDate data) {
		super();
		this.numeroBadge = numeroBadge;
		this.data = data;
	}
	public TornelloDTO() {
		super();
	}
	

	
	
	
	
}
