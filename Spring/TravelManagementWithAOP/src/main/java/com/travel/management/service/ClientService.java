package com.travel.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.dao.ClientDao;
import com.travel.management.entity.Client;

@Service
public class ClientService {

	@Autowired
	ClientDao dao;
	
	public Client findClientByPhone(String phone) {
		return dao.findClientByPhone(phone);
	}
	
	public Client findClientByEmail(String email) {
		return dao.findClientByPhone(email);
	}
}
