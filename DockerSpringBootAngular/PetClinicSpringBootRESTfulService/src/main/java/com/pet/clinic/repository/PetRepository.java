package com.pet.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.clinic.bean.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
