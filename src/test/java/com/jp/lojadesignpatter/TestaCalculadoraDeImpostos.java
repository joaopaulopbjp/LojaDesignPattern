package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.tax.Imposto;
import com.jp.lojadesignpatter.model.tax.ImpostoICMS;
import com.jp.lojadesignpatter.model.tax.ImpostoISS;

class TestaCalculadoraDeImpostos {
	private Orcamento orcamento;
	
	@BeforeEach
	public void configuraTeste() {
		this.orcamento = new Orcamento(new BigDecimal("100").setScale(2),1);
	}

	@Test
	void calculaImpostoICMSSobreOrcamento() {
		Imposto impostoICMS = new ImpostoICMS();
		
		assertEquals(new BigDecimal("10").setScale(2), impostoICMS.calcularImpostoComposto(orcamento.getValor()));
	}
	
	@Test
	void calculaImpostoISSSobreOrcamento() {		
		Imposto impostoISS = new ImpostoISS();
		
		assertEquals(new BigDecimal("1.5").setScale(2), impostoISS.calcularImpostoComposto(orcamento.getValor()));
	}
	
	@Test
	void calculaImpostoISSCompostoComICMSSobreOrcamento() {	
		Imposto impostoICMS = new ImpostoICMS();
		Imposto impostoISSComICMS = new ImpostoISS(impostoICMS);
		
		assertEquals(new BigDecimal("11.5").setScale(2), impostoISSComICMS.calcularImpostoComposto(orcamento.getValor()));
	}

}
