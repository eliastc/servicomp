package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemChamado implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemChamadoPK id = new ItemChamadoPK();
	
	private BigDecimal desconto;
	private BigDecimal valorHora;
	private Integer duracao;
	
	public ItemChamado() {		
	}

	public ItemChamado(Chamado chamado, Profissional profissional, BigDecimal desconto, BigDecimal valorHora, Integer duracao) {
		super();
		id.setChamado(chamado);
		id.setProfissional(profissional);
		this.desconto = desconto;
		this.valorHora = valorHora;
		this.duracao = duracao;
	}
	
	@JsonIgnore
	public Chamado getChamado() {
		return id.getChamado();
	}
	
	public Profissional getProfissional() {
		return id.getProfissional();
	}

	public ItemChamadoPK getId() {
		return id;
	}

	public void setId(ItemChamadoPK id) {
		this.id = id;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemChamado other = (ItemChamado) obj;
		return Objects.equals(id, other.id);
	}
}
