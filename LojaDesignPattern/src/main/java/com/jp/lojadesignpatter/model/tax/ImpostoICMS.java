package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

public class ImpostoICMS implements Imposto {

	@Override
	public BigDecimal calcularImposto(BigDecimal valorOrcamento) {
		
		return valorOrcamento.multiply(new BigDecimal("0.1").setScale(2)).setScale(2);
	}

}
