package com.project.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.DipendenteModel;

@Repository
public interface DipendenteRepository extends JpaRepository <DipendenteModel, Integer> {
	
	public List<DipendenteModel> deleteByNumeroBadge(String numeroBadge);
	public DipendenteModel findOneByNumeroBadge(String numeroBadge);

}
