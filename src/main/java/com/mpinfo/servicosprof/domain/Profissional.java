package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Profissional implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	private String celular;
	private String formacao;
	private Integer classificacao;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(
			name = "PROFISSIONAL_PROFISSAO",
			joinColumns = @JoinColumn(name = "profissional_id"),
			inverseJoinColumns = @JoinColumn(name = "profissao_id")
			)
	private List<Profissao> profissoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.profissional")
	private Set<ItemChamado> itens = new HashSet<>();
	
	
	// talvez tenha que associar o chamado com o cliente e com o profissional
	public Profissional() {		
	}

	public Profissional(Long id, String nome, String celular, String formacao, Integer classificacao) {
		super();
		this.id = id;
		this.nome = nome;	
		this.celular = celular;
		this.formacao = formacao;
		this.setClassificacao(classificacao);
	}

	@JsonIgnore
	public List<Chamado> getChamados() {
		List<Chamado> lista = new ArrayList<>();
		for(ItemChamado x: itens) {
			lista.add(x.getChamado());
		}
		return lista;
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

	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}
	
	public List<Profissao> getProfissoes() {
		return profissoes;
	}

	public void setProfissoes(List<Profissao> profissoes) {
		this.profissoes = profissoes;
	}
	

	public Set<ItemChamado> getItens() {
		return itens;
	}

	public void setItens(Set<ItemChamado> itens) {
		this.itens = itens;
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
