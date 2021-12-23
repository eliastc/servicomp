package com.mpinfo.servicosprof;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;

@SpringBootApplication
public class ServicosprofApplication implements CommandLineRunner {

	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicosprofApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Profissao prof1 = new Profissao(null, "Técnico em Informática");
		Profissao prof2 = new Profissao(null, "Advogado(a)");
		profissaoRepository.saveAll(Arrays.asList(prof1, prof2));
		
		
	}

}
