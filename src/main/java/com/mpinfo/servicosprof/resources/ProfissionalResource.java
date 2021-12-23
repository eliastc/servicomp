package com.mpinfo.servicosprof.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.services.ProfissionalService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Profissional obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
}
