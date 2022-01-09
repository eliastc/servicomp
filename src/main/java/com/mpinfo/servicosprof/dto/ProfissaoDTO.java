package com.mpinfo.servicosprof.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.mpinfo.servicosprof.domain.Profissao;

public class ProfissaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 80, message ="O tamanho deve está entre 3 e 80 caracteres" )
	private String nome;
	
	public ProfissaoDTO() {		
	}
	
	public ProfissaoDTO(Profissao obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}
