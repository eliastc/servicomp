package com.mpinfo.servicosprof.dto;

import java.io.Serializable;

import com.mpinfo.servicosprof.domain.Profissional;

public class ProfissionalDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;	
	private String celular;
	private String endereco;
	private String bairro;
	
	public ProfissionalDTO() {		
	}
	
	public ProfissionalDTO(Profissional obj) {
		id = obj.getId();
		nome = obj.getNome();
		celular = obj.getCelular();
		endereco = obj.getEndereco();
		bairro = obj.getBairro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
