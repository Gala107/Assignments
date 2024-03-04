package com.pet.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.clinic.bean.Visit;
import com.pet.clinic.repository.VisitRepository;

@Service
public class VisitService {

	@Autowired
	VisitRepository repository;
	
	public Visit saveVisit(Visit visit) {
		return repository.save(visit);
	}
}
