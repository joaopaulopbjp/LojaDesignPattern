package com.jp.lojadesignpatter.model.discount;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class CalculadoraDeDesconto {
	
public BigDecimal calculaDesconto(Orcamento orcamento, Desconto desconto) {
	
	return desconto.calculaDesconto(orcamento);
}

}
