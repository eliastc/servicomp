package com.mpinfo.servicosprof.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Chamado;
import com.mpinfo.servicosprof.repositories.ChamadoRepository;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repo;
	
	public Chamado find(Long id) {
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ExcessaoNaoEncontradaException("Objeto não encontrado! Id: " + id +
				", Tipo: " + Chamado.class.getName()));
		}
}
