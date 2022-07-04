package com.jp.lojadesignpatter.model.tax;

import java.math.BigDecimal;

public interface Imposto {

	public BigDecimal calcularImposto(BigDecimal valorOrcamento);
}
