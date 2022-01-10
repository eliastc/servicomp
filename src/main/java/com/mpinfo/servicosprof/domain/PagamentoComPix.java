package com.mpinfo.servicosprof.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mpinfo.servicosprof.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComPix")
public class PagamentoComPix extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern ="dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	/*
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataPagamento;
	*/
	public PagamentoComPix() {		
	}
//, Date dataPagamento  no construtor
	public PagamentoComPix(Integer id, EstadoPagamento estado, Chamado chamado, Date dataVencimento) {
		super(id, estado, chamado);
	//	this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
/*
	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	} */
}
