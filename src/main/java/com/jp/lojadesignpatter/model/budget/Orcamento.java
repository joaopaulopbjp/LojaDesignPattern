package com.jp.lojadesignpatter.model.budget;

import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;
	private int quantidadeItens;

	public Orcamento(BigDecimal valor, int qtdItens) {
		super();
		this.valor = valor;
		this.quantidadeItens = qtdItens;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
	
}
