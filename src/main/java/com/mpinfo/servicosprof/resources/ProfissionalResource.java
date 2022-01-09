package com.mpinfo.servicosprof.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.dto.ProfissionalDTO;
import com.mpinfo.servicosprof.resources.utils.URL;
import com.mpinfo.servicosprof.services.ProfissionalService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profissional> find(@PathVariable Integer id) {
		
		Profissional obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProfissionalDTO>> findPage(
			@RequestParam(value = "", defaultValue = "") String nome,
			@RequestParam(value = "profissoes", defaultValue = "0") String profissoes,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nomeDecode = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeList(profissoes);
		Page<Profissional>  list = service.search(nomeDecode, ids, page, linesPerPage, orderBy, direction);
		Page<ProfissionalDTO> listDto = list.map(obj -> new ProfissionalDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
