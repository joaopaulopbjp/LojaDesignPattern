package com.jp.lojadesignpatter.model.budget;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.status.OrcamentoEmAnalise;
import com.jp.lojadesignpatter.model.budget.status.SituacaoOrcamento;

public class Orcamento {

	private BigDecimal valor;
	private int quantidadeItens;
	private SituacaoOrcamento situacao;

	public Orcamento(BigDecimal valor, int qtdItens) {
		super();
		this.valor = valor;
		this.quantidadeItens = qtdItens;
		this.situacao = new OrcamentoEmAnalise();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}
	
	public BigDecimal calculaDescontoExtra() {
		return this.valor.subtract(this.situacao.calculaDescontoExtra(this));
	}
	
	public void aprovarOrcamento() {
		this.situacao.aprovar(this);
	}
	
	public void reprovarOrcamento() {
		this.situacao.reprovar(this);
	}
	
	public void finalizarOrcamento() {
		this.situacao.finalizar(this);
	}
	
}
