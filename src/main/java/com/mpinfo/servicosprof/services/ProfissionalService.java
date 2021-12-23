package com.mpinfo.servicosprof.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository repo;
	
	public Profissional find(Long id) {
		Optional<Profissional> obj = repo.findById(id);
		return obj.orElse(null);
		}

}
