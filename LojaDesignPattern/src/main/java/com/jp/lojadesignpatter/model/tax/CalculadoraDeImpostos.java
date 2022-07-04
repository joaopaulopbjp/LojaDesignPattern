package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class CalculadoraDeImpostos {

	public BigDecimal calculaImpostos(Orcamento orc, Imposto imposto) {
				
		return imposto.calcularImposto(orc.getValor());
	}
}
