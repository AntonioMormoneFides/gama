package com.project.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.DipendenteModel;
@Repository
public interface DipendenteRepository extends JpaRepository <DipendenteModel, Integer> {
	
	public void deleteByNumeroBadge(String numeroBadge);
	public DipendenteModel findByNumeroBadge(String numeroBadge);
	

}
