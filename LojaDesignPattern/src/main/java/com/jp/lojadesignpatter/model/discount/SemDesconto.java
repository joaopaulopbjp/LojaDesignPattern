package com.jp.lojadesignpatter.model.discount;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal efetuaRegraDesconto(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	
	public boolean verificaDesconto(Orcamento orcamento) {
		return true;
	}
}
