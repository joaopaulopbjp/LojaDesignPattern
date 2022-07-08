package com.jp.lojadesignpatter.model.budget.status;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.exception.SituacaoException;
import com.jp.lojadesignpatter.model.budget.Orcamento;

public abstract class SituacaoOrcamento {
	
	public BigDecimal calculaDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new SituacaoException("Orcamento não pode ser aprovado.");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new SituacaoException("Orcamento não pode ser reprovado.");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new SituacaoException("Orcamento não pode ser finalizado.");
	}
}
