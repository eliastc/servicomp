package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ItemChamadoPK implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "chamado_id")
	private Chamado chamado;
	
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	
	public Chamado getChamado() {
		return chamado;
	}
	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(chamado, profissional);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemChamadoPK other = (ItemChamadoPK) obj;
		return Objects.equals(chamado, other.chamado) && Objects.equals(profissional, other.profissional);
	}
}
