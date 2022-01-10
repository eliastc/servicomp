package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemChamadoPK id = new ItemChamadoPK();

	private Double desconto;
	private Double valorHora;
	private Integer duracao;
	// contar a duracao apartir da chegado do profissional no cliente que sera contada(calculada) no final do atendimento.

	public ItemChamado() {
	}

	public ItemChamado(Chamado chamado, Profissional profissional, Double desconto, Double valorHora,
			Integer duracao) {
		super();
		id.setChamado(chamado);
		id.setProfissional(profissional);
		this.desconto = desconto;
		this.valorHora = valorHora;
		this.duracao = duracao;
	}
	
	public double getSubTotal() {
		return (valorHora - desconto) * duracao;
	}
	

	@JsonIgnore
	public Chamado getChamado() {
		return id.getChamado();
	}
	
	public void setChamado(Chamado chamado) {
		id.setChamado(chamado);
	}

	public Profissional getProfissional() {
		return id.getProfissional();
	}

	public void setProfissional(Profissional profissional) {
		id.setProfissional(profissional);
	}
	
	public ItemChamadoPK getId() {
		return id;
	}

	public void setId(ItemChamadoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
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
