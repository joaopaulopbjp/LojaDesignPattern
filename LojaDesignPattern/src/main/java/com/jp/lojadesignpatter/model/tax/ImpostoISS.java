package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

public class ImpostoISS implements Imposto {

	@Override
	public BigDecimal calcularImposto(BigDecimal valorOrcamento) {
		
		return valorOrcamento.multiply(new BigDecimal("0.015").setScale(3)).setScale(2);
	}

}
