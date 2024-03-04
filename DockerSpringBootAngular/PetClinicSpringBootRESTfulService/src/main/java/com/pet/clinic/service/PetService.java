package com.pet.clinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.clinic.bean.Pet;
import com.pet.clinic.repository.PetRepository;

@Service
public class PetService {
	
	@Autowired
	PetRepository repository;
	
	public Pet savePet(Pet pet) {
		return repository.save(pet);
	}
	
	public Pet getPetById(Integer id) {
		Optional<Pet> opt = repository.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
}
