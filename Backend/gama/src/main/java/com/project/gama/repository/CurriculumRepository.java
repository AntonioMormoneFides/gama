package com.project.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gama.model.CurriculumModel;

@Repository
public interface CurriculumRepository extends JpaRepository<CurriculumModel, Integer>{

}
