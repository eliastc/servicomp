package com.mpinfo.servicosprof.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.Chamado;
import com.mpinfo.servicosprof.domain.ItemChamado;
import com.mpinfo.servicosprof.domain.PagamentoComPix;
import com.mpinfo.servicosprof.domain.enums.EstadoPagamento;
import com.mpinfo.servicosprof.repositories.ChamadoRepository;
import com.mpinfo.servicosprof.repositories.ItemChamadoRepository;
import com.mpinfo.servicosprof.repositories.PagamentoRepository;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repo;
	
	@Autowired
	private PixService pixService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemChamadoRepository itemChamadoRepository;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	public Chamado find(Integer id) {
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ExcessaoNaoEncontradaException("Objeto não encontrado! Id: " + id +
				", Tipo: " + Chamado.class.getName()));
		}
	//fazer na classe prof. os atributos hora inicio e hora fim para calcular o tempo de duracao
	@Transactional
	public Chamado insert(Chamado obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setChamado(obj);
		if(obj.getPagamento() instanceof PagamentoComPix) {
			PagamentoComPix pagto = (PagamentoComPix) obj.getPagamento();
			pixService.preencherPagamentoComPix(pagto, obj.getInstante());
		}		
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemChamado ic : obj.getItens()) {
			ic.setDesconto(0.0);
		//	ic.setDuracao(1); criar um metodo para calcular essa duracao
			ic.setProfissional(profissionalService.find(ic.getProfissional().getId()));
			ic.setValorHora(ic.getProfissional().getValorHora());		
			ic.setChamado(obj);
		}		
		itemChamadoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
}
