package com.mpinfo.servicosprof.domain.enums;

public enum TipoClassificacao {
	INESPERIENTE(1, "Inexperiente"),
	EXPERIENTE(2, "Experiente"),
	EXCELENTE (3, "Excelente");
	
	private int cod;
	private String descricao;
	
	private TipoClassificacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoClassificacao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoClassificacao x : TipoClassificacao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}			
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
