package com.mpinfo.servicosprof.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Chamado implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern ="dd/MM/yyyy HH:mm")
	private Date instante;
	
	private String mensagem;	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "chamado")	
	private Pagamento pagamento;
			
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
/*		
	//testar post no postman tirando esse atributo 
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
*/	
	@JsonIgnore
	@OneToMany(mappedBy = "chamado")
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "id.chamado")
	private Set<ItemChamado> itens = new HashSet<>();
	
	
	// talvez tenha que associar o chamado com o cliente e com o profissional
	public Chamado() {		
	}
	//Profissional profissional no construtor
	public Chamado(Integer id, Date instante, String mensagem, Cliente cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.mensagem = mensagem;		
		this.cliente = cliente;		
	//	this.profissional = profissional;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		for(ItemChamado ic : itens) {
			soma = soma + ic.getSubTotal();
		}
		
		return soma;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
/*
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	*/
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Número do chamado: ");
		builder.append(getId());
		builder.append(", instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		builder.append("\nDetalhes:\n");
		for(ItemChamado ic : getItens()) {
			builder.append(ic.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}
	
	

}
