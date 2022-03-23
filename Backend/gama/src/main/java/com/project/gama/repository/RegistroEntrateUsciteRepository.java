package com.project.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.RegistroEntrateUsciteModel;

@Repository
public interface RegistroEntrateUsciteRepository extends JpaRepository<RegistroEntrateUsciteModel, Integer> {

}
