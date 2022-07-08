package com.jp.lojadesignpatter.model.budget.status;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class OrcamentoEmAnalise extends SituacaoOrcamento {

	@Override
	public BigDecimal calculaDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05")).setScale(2);
	}

	@Override
	public void aprovar(Orcamento orcamento) {
		orcamento.setSituacao(new OrcamentoAprovado());
	}

	@Override
	public void reprovar(Orcamento orcamento) {
		orcamento.setSituacao(new OrcamentoReprovado());
	}

	
}
