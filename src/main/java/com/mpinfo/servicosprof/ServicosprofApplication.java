package com.mpinfo.servicosprof;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;
import com.mpinfo.servicosprof.repositories.ProfissionalRepository;

@SpringBootApplication
public class ServicosprofApplication implements CommandLineRunner {

	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicosprofApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Profissao prof1 = new Profissao(null, "Técnico em Informática");
		Profissao prof2 = new Profissao(null, "Advogado(a)");
		
		
		Profissional tec = new Profissional(null, "Elias", "81988243638", "Bacharel em Sistemas");
		Profissional adv = new Profissional(null, "Ana Cristina", "81988423639", "Bacharel em Direito");
		
		
		prof1.getProfissionais().addAll(Arrays.asList(tec));
		prof2.getProfissionais().addAll(Arrays.asList(adv));
		
		tec.getProfissoes().addAll(Arrays.asList(prof1));
		adv.getProfissoes().addAll(Arrays.asList(prof2));
		
		profissaoRepository.saveAll(Arrays.asList(prof1, prof2));
		profissionalRepository.saveAll(Arrays.asList(tec, adv));
	}

}
