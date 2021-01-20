package com.algaworks.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.BusinessException;
import com.algaworks.osworks.domain.model.Client;
import com.algaworks.osworks.domain.repository.ClientRepository;

@Service
public class RegisterClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public Client save(Client client) {
		Client clientExisting = clientRepository.findByEmail(client.getEmail());
		
		if (clientExisting != null && !clientExisting.equals(client)) {
			throw new BusinessException("E-mail already registered.");
		}
		return clientRepository.save(client);
	}
	
	public void delete (Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
