package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.exception.SituacaoException;
import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.discount.Desconto;
import com.jp.lojadesignpatter.model.discount.DescontoQuantidadeItensMaiorQueCinco;
import com.jp.lojadesignpatter.model.discount.DescontoValorMaiorQueQuinhentos;
import com.jp.lojadesignpatter.model.discount.SemDesconto;

class TestaSituacaoEDescontosExtraOrcamento {
	private Orcamento orcamento;
	
	@BeforeEach
	public void configuraTeste() {
		this.orcamento = new Orcamento(new BigDecimal("1000").setScale(2),1);
	}

	@Test
	public void testaDescontoExtraOrcamentoNovo() {
		assertEquals(new BigDecimal("950").setScale(2),orcamento.calculaDescontoExtra());
	}

	@Test
	public void testaDescontoExtraOrcamentoAprovado() {
		try {
			this.orcamento.aprovarOrcamento();	
		} catch (SituacaoException e) {
			fail();
		}
		assertEquals(new BigDecimal("980").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaDescontoExtraOrcamentoReprovado() {
		try {
			this.orcamento.reprovarOrcamento();	
		} catch (SituacaoException e) {
			fail();
		}
		assertEquals(new BigDecimal("1000").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaDescontoExtraOrcamentoFinalizadoAposReprovacao() {
		try {
			this.orcamento.reprovarOrcamento();	
			this.orcamento.finalizarOrcamento();	
		} catch (SituacaoException e) {
			fail();
		}
		assertEquals(new BigDecimal("1000").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaSituacaoOrcamentoNovoDepoisFinalizado() {
		try {
			this.orcamento.finalizarOrcamento();	
		} catch (SituacaoException e) {
			assertEquals("Orcamento não pode ser finalizado.", e.getMessage());
		}
	}
}
