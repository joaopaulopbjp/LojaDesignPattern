package com.jp.lojadesignpatter.model.discount;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class DescontoQuantidadeItensMaiorQueCinco extends Desconto {

	public DescontoQuantidadeItensMaiorQueCinco(Desconto next) {
		super(next);
	}

	@Override
	public BigDecimal efetuaRegraDesconto(Orcamento orcamento) {
		
		return orcamento.getValor().multiply(new BigDecimal("0.05").setScale(2)).setScale(2);
	}
	
	public boolean verificaDesconto(Orcamento orcamento) {
		return orcamento.getQuantidadeItens()>5;
	}

}
