package com.project.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.MansioniLavorativeModel;

@Repository
public interface MansioniLavorativeRepository extends JpaRepository <MansioniLavorativeModel, Integer> {

}
