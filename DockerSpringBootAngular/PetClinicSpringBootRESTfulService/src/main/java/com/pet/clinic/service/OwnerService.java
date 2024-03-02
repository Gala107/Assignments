package com.pet.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.clinic.bean.Owner;
import com.pet.clinic.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository repository;
	
	public Owner getOwnerByPhone(String phone) {
		return repository.findByPhone(phone);
	}
	
	public Owner getOwnerByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Owner saveOwner(Owner owner) {
		return repository.save(owner);
	}
}
