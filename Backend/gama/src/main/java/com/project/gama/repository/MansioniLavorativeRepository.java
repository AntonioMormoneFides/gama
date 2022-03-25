package com.project.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.DipendenteModel;
import com.project.gama.model.MansioniLavorativeModel;

@Repository
public interface MansioniLavorativeRepository extends JpaRepository <MansioniLavorativeModel, Long> {
	public List<MansioniLavorativeModel> findAllByDipendente(DipendenteModel dipendente);

}
