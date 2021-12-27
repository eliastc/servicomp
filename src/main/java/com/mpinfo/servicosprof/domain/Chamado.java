package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chamado implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern ="dd/MM/yyyy HH:mm")
	private Date instante;
	private String mensagem;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "chamado")	
	private Pagamento pagamento;
	
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "entrega_id")
	private Endereco enderecodeEntrega;
	
	@OneToMany(mappedBy = "id.chamado")
	private Set<ItemChamado> itens = new HashSet<>();
	
	
	// talvez tenha que associar o chamado com o cliente e com o profissional
	public Chamado() {		
	}

	public Chamado(Long id, Date instante, String mensagem, Cliente cliente,
			Endereco enderecodeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.mensagem = mensagem;		
		this.cliente = cliente;
		this.enderecodeEntrega = enderecodeEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecodeEntrega() {
		return enderecodeEntrega;
	}

	public void setEnderecodeEntrega(Endereco enderecodeEntrega) {
		this.enderecodeEntrega = enderecodeEntrega;
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
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}
}
