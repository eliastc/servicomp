package com.mpinfo.servicosprof.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;
import com.mpinfo.servicosprof.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repo;
	
	@Autowired
	private ProfissaoRepository profissaoRepository;

	public Profissional find(Integer id) {
		Optional<Profissional> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Page<Profissional> search(String nome, List<Integer> ids, Integer page,
			Integer linesPerPage, String orderBy, String direction) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		List<Profissao> profissoes = profissaoRepository.findAllById(ids);
		return repo.search(nome, profissoes, pageRequest);
		
	}
}
