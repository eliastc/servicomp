package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.util.Objects;

public class Profissional implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String whatsapp;
	private String curriculo;
	
	public Profissional() {		
	}

	public Profissional(Long id, String nome, String whatsapp, String curriculo) {
		super();
		this.id = id;
		this.nome = nome;
		this.whatsapp = whatsapp;
		this.curriculo = curriculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
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
		Profissional other = (Profissional) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
