package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

public class ImpostoICMS extends Imposto {

	public ImpostoICMS(Imposto impostoDecorator) {
		super(impostoDecorator);
	}
	
	public ImpostoICMS() {
		super(null);
	}

	@Override
	public BigDecimal calcularImposto(BigDecimal valorOrcamento) {
		
		return valorOrcamento.multiply(new BigDecimal("0.1").setScale(2)).setScale(2);
	}

}
