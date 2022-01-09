package com.mpinfo.servicosprof.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.dto.ProfissaoDTO;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoIntegridadeDados;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao find(Integer id) {
		Optional<Profissao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ExcessaoNaoEncontradaException("Objeto não encontrado! Id: " + id +
				", Tipo: " + Profissao.class.getName()));
		}
	
	public Profissao insert(Profissao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Profissao update(Profissao obj) {
		Profissao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);		
	}
	
	private void updateData(Profissao newObj, Profissao obj) {
		newObj.setNome(obj.getNome());		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExcessaoIntegridadeDados("Não é possivel excluir pois possui dados integrados! ");
		}
	}
	public List<Profissao> findAll() {
		return repo.findAll();
	}
	
	public Page<Profissao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Profissao fromDTO(ProfissaoDTO objDto) {
		return new Profissao(objDto.getId(), objDto.getNome());
	}
}
