package com.pet.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.clinic.bean.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
