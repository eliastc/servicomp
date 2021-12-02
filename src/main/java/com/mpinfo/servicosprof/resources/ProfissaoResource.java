package com.mpinfo.servicosprof.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profissoes")
public class ProfissaoResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest funcionando";
	}
}
