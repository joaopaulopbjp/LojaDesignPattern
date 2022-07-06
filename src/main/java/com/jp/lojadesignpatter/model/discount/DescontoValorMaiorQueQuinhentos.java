package com.jp.lojadesignpatter.model.discount;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class DescontoValorMaiorQueQuinhentos extends Desconto {

	public DescontoValorMaiorQueQuinhentos(Desconto next) {
		super(next);
	}

	@Override
	public BigDecimal efetuaRegraDesconto(Orcamento orcamento) {

		return  orcamento.getValor().multiply(new BigDecimal("0.1").setScale(2)).setScale(2);
	}

	public boolean verificaDesconto(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal("500").setScale(2)) > 0;
	}
}
