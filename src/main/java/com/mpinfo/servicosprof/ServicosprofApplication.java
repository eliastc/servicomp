package com.mpinfo.servicosprof;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mpinfo.servicosprof.domain.Chamado;
import com.mpinfo.servicosprof.domain.Cidade;
import com.mpinfo.servicosprof.domain.Cliente;
import com.mpinfo.servicosprof.domain.Endereco;
import com.mpinfo.servicosprof.domain.Estado;
import com.mpinfo.servicosprof.domain.ItemChamado;
import com.mpinfo.servicosprof.domain.Pagamento;
import com.mpinfo.servicosprof.domain.PagamentoComCartao;
import com.mpinfo.servicosprof.domain.PagamentoComPix;
import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.domain.Profissional;
import com.mpinfo.servicosprof.domain.enums.EstadoPagamento;
import com.mpinfo.servicosprof.domain.enums.TipoClassificacao;
import com.mpinfo.servicosprof.domain.enums.TipoCliente;
import com.mpinfo.servicosprof.repositories.ChamadoRepository;
import com.mpinfo.servicosprof.repositories.CidadeRepository;
import com.mpinfo.servicosprof.repositories.ClienteRepository;
import com.mpinfo.servicosprof.repositories.EnderecoRepository;
import com.mpinfo.servicosprof.repositories.EstadoRepository;
import com.mpinfo.servicosprof.repositories.ItemChamadoRepository;
import com.mpinfo.servicosprof.repositories.PagamentoRepository;
import com.mpinfo.servicosprof.repositories.ProfissaoRepository;
import com.mpinfo.servicosprof.repositories.ProfissionalRepository;


@SpringBootApplication
public class ServicosprofApplication implements CommandLineRunner {

	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemChamadoRepository itemChamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicosprofApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Profissao prof1 = new Profissao(null, "Técnico em Informática");
		Profissao prof2 = new Profissao(null, "Advogado(a)");
		Profissao prof3 = new Profissao(null, "Engenheiro(a)");
		Profissao prof4 = new Profissao(null, "Medico(a)");
		
		
		Profissional tec = new Profissional(null, "Elias","(81) 98822.7788", "Bacharel em Sistemas", 3);
	//	tec.getTelefones().addAll(Arrays.asList("(81) 98824.3638"));
		Profissional adv = new Profissional(null, "Ana Cristina","(81) 98843.8787", "Bacharel em Direito", 3);
	//	adv.getTelefones().addAll(Arrays.asList("(81) 98842.3639"));
		Profissional eng = new Profissional(null, "Erisson Alberto","(81) 99887.7552", "Bacharel em Engenharia", 3);
	//	eng.getTelefones().addAll(Arrays.asList("(81) 98989899"));
		Profissional dr = new Profissional(null, "Heitor Vinícius","(81) 99778.8112", "Bacharel em Medicina", 3);
	//	dr.getTelefones().addAll(Arrays.asList("(81) 9797979797"));
		
		
		prof1.getProfissionais().addAll(Arrays.asList(tec));
		prof2.getProfissionais().addAll(Arrays.asList(adv));
		prof3.getProfissionais().addAll(Arrays.asList(eng));
		prof4.getProfissionais().addAll(Arrays.asList(dr));
		
		tec.getProfissoes().addAll(Arrays.asList(prof1));
		adv.getProfissoes().addAll(Arrays.asList(prof2));
		eng.getProfissoes().addAll(Arrays.asList(prof3));
		dr.getProfissoes().addAll(Arrays.asList(prof4));
		
		profissaoRepository.saveAll(Arrays.asList(prof1, prof2, prof3, prof4));
		profissionalRepository.saveAll(Arrays.asList(tec, adv, eng, dr));
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Paraiba");
		
		Cidade cid1 = new Cidade(null, "Recife", est1);
		Cidade cid2 = new Cidade(null, "Campina Grande", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		
	//	Cliente cli1 = new Cliente(null, "Carlos", "carlos@gmail.com", "36378912377", TipoClassificacao.EXCELENTE, TipoCliente.PESSOAFISICA);
		
		Cliente cli1 = new Cliente(null, "sede das Miudezas", "sede@gmail.com", "02067185000185", TipoClassificacao.EXCELENTE, TipoCliente.PESSOAJURIDICA );
		cli1.getTelefones().addAll(Arrays.asList("3339.0990", "9988776655"));
		
		Endereco end1 = new Endereco(null, "Rua Guarabira", "192", "A", "Imbiribeira", "50.000-010", cli1, cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Chamado cha1 = new Chamado(null, sdf.parse("26/12/2021 13:45"), "Notebook não liga", cli1, end1);
		Chamado cha2 = new Chamado(null, sdf.parse("26/12/2021 13:50"), "Ação trabalhista", cli1, end1);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, cha1, 2);
		cha1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComPix(null, EstadoPagamento.PENDENTE, cha2, sdf.parse("10/01/2022 15:00"), null);
		cha2.setPagamento(pagto2);
		
		cli1.getChamados().addAll(Arrays.asList(cha1, cha2));
		
		chamadoRepository.saveAll(Arrays.asList(cha1, cha2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemChamado ip1 = new ItemChamado(cha1, tec, new BigDecimal("0.00"), new BigDecimal("100.00"), 4);
		ItemChamado ip2 = new ItemChamado(cha2, adv, new BigDecimal("0.00"), new BigDecimal("7000.00"), 3);
		
		cha1.getItens().addAll(Arrays.asList(ip1));
		cha2.getItens().addAll(Arrays.asList(ip2));
		
		tec.getItens().addAll(Arrays.asList(ip1));
		adv.getItens().addAll(Arrays.asList(ip2));
		
		itemChamadoRepository.saveAll(Arrays.asList(ip1, ip2));
	}

}
