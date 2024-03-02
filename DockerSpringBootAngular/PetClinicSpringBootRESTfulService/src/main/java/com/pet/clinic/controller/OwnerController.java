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
import com.pet.clinic.service.OwnerService;

@RestController
@CrossOrigin
@RequestMapping("owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@GetMapping(value = "getOwner/{findBy}/{ownerInfo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner getOwner(@PathVariable("findBy") String findBy, @PathVariable("ownerInfo") String ownerInfo) {
		if ("phone".equals(findBy)) {
			return ownerService.getOwnerByPhone(ownerInfo);
		} else if ("email".equals(findBy)) {
			return ownerService.getOwnerByEmail(ownerInfo);
		}
		return null;
	}

//	@PostMapping(value = "createOwner", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String createOwner(@RequestBody Owner owner) {
//		Integer id = ownerService.saveOwner(owner).getId();
//		return id.toString();
//	}
	

	@PostMapping(value = "createOwner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
}
