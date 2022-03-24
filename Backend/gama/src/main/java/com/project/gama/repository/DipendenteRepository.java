package com.project.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gama.model.DipendenteModel;

public interface DipendenteRepository extends JpaRepository <DipendenteModel, Integer> {
	
	public List<DipendenteModel> deleteByNumeroBadge(String numeroBadge);

}
