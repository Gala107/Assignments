package com.taxi.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.reservation.repository.ClientRepository;
import com.taxi.reservation.bean.Client;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	public Client findClientByPhone(String phone) {
		return repository.findByPhone(phone);
	}
	
	public Client findClientByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public void saveClient(Client client) {
		repository.save(client);
	}
}
