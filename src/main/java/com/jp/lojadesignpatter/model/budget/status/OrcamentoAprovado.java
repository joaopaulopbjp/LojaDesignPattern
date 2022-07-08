package com.jp.lojadesignpatter.model.budget.status;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class OrcamentoAprovado extends SituacaoOrcamento {

	@Override
	public BigDecimal calculaDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.02")).setScale(2);
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new OrcamentoFinalizado());
	}

}
