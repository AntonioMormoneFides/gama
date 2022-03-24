package com.project.gama.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.DipendenteModel;
import com.project.gama.model.RegistroEntrateUsciteModel;

@Repository
public interface RegistroEntrateUsciteRepository extends JpaRepository<RegistroEntrateUsciteModel, Integer> {

	RegistroEntrateUsciteModel findOneByDipendenteAndGiorno(DipendenteModel dp, LocalDate giorno);
	
	
	
	
}
