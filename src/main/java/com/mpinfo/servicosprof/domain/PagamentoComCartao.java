package com.mpinfo.servicosprof.domain;

import javax.persistence.Entity;

import com.mpinfo.servicosprof.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numerodeParcelas;
	
	public PagamentoComCartao() {		
	}

	public PagamentoComCartao(Long id, EstadoPagamento estado, Chamado chamado, Integer numeroDeParcelas) {
		super(id, estado, chamado);
		this.numerodeParcelas = numeroDeParcelas;
	}

	public Integer getNumerodeParcelas() {
		return numerodeParcelas;
	}

	public void setNumerodeParcelas(Integer numerodeParcelas) {
		this.numerodeParcelas = numerodeParcelas;
	}
	
	

}
