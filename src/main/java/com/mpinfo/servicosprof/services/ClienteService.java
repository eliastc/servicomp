package com.mpinfo.servicosprof.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Cliente;
import com.mpinfo.servicosprof.repositories.ClienteRepository;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ExcessaoNaoEncontradaException("Objeto não encontrado! Id: " + id +
				", Tipo: " + Cliente.class.getName()));
		}
}
