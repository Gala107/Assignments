package com.pet.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.bean.Owner;
import com.pet.clinic.bean.Pet;
import com.pet.clinic.bean.Visit;
import com.pet.clinic.service.OwnerService;
import com.pet.clinic.service.PetService;
import com.pet.clinic.service.VisitService;

@RestController
@CrossOrigin
@RequestMapping("petclinic")
public class PetClinicController {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PetService petService;
	@Autowired
	private VisitService visitService;

	@GetMapping(value = "getOwner/{findBy}/{ownerInfo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner getOwner(@PathVariable("findBy") String findBy, @PathVariable("ownerInfo") String ownerInfo) {
		if ("phone".equals(findBy)) {
			return ownerService.getOwnerByPhone(ownerInfo);
		} else if ("email".equals(findBy)) {
			return ownerService.getOwnerByEmail(ownerInfo);
		}
		return null;
	}

	@PostMapping(value = "createOwner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@GetMapping(value = "getOwnerById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		return ownerService.getOwnerById(id);
	}
	
	@GetMapping(value = "getPetById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pet getPetById(@PathVariable("id") Integer id) {
		return petService.getPetById(id);
	}
	
	@PostMapping(value = "addPet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner addPet(@RequestBody Pet pet) {
		petService.savePet(pet);
		return ownerService.getOwnerById(pet.getOwnerId());
	}
	
	@PostMapping(value = "addVisit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pet addVisit(@RequestBody Visit visit) {
		visitService.saveVisit(visit);
		return petService.getPetById(visit.getPetId());
	}
}

