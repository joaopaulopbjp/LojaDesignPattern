package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.exception.SituacaoException;
import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.budget.status.OrcamentoFinalizado;
import com.jp.lojadesignpatter.model.budget.status.SituacaoOrcamento;


class TestaSituacaoOrcamento {
	private SituacaoOrcamento situacao;
	private Orcamento orcam;
	
	@BeforeEach
	public void configuraTeste() {
		this.situacao = new OrcamentoFinalizado();
		this.orcam = new Orcamento(new BigDecimal("1000").setScale(2),1);
	}

	@Test
	public void testaFinaliza() {
		try {
			this.situacao.finalizar(this.orcam);	
		} catch (SituacaoException e) {
			assertEquals("Orcamento não pode ser finalizado.", e.getMessage());
		}
	}
}
