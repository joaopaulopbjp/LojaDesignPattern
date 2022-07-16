package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

public abstract class Imposto {
	private Imposto impostoDecorator;

	public Imposto(Imposto impostoDecorator) {
		this.impostoDecorator = impostoDecorator;
	}

	protected abstract BigDecimal calcularImposto(BigDecimal valorOrcamento);
	
	public BigDecimal calcularImpostoComposto(BigDecimal valorOrcamento) {
		BigDecimal imposto = calcularImposto(valorOrcamento);
		BigDecimal outroImpostoDecorator = BigDecimal.ZERO;
		
		if (this.impostoDecorator != null) {
			outroImpostoDecorator = this.impostoDecorator.calcularImposto(valorOrcamento);
		}
		
		return imposto.add(outroImpostoDecorator);
	}
}
