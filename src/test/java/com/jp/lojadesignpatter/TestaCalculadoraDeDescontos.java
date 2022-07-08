package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.discount.CalculadoraDeDesconto;
import com.jp.lojadesignpatter.model.discount.Desconto;
import com.jp.lojadesignpatter.model.discount.DescontoQuantidadeItensMaiorQueCinco;
import com.jp.lojadesignpatter.model.discount.DescontoValorMaiorQueQuinhentos;
import com.jp.lojadesignpatter.model.discount.SemDesconto;

class TestaCalculadoraDeDescontos {
	private Orcamento orcamento;
	private CalculadoraDeDesconto calcDesc;
	
	@BeforeEach
	public void configuraTeste() {
		this.orcamento = new Orcamento(new BigDecimal("1000").setScale(2),1);
		calcDesc = new CalculadoraDeDesconto();
	}

	@Test
	void calculaCalculadoraDescontoComDescontoValorMaiorQueQuinhentos() {
		
		Desconto descontoValorMaiorQuinhentos = new DescontoValorMaiorQueQuinhentos(new SemDesconto());
		
		assertEquals(new BigDecimal("100").setScale(2), this.calcDesc.calculaDesconto(this.orcamento, descontoValorMaiorQuinhentos));
	}

}
