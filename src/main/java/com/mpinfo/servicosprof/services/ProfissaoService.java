package com.mpinfo.servicosprof.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao find(Long id) {
		Optional<Profissao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ExcessaoNaoEncontradaException("Objeto não encontrado! Id: " + id +
				", Tipo: " + Profissao.class.getName()));
		}
}
