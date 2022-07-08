package com.jp.lojadesignpatter.model.budget.status;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class OrcamentoReprovado extends SituacaoOrcamento {

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new OrcamentoFinalizado());
	}

}
