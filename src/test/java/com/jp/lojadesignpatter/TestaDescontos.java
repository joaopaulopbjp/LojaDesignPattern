package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.discount.Desconto;
import com.jp.lojadesignpatter.model.discount.DescontoQuantidadeItensMaiorQueCinco;
import com.jp.lojadesignpatter.model.discount.DescontoValorMaiorQueQuinhentos;
import com.jp.lojadesignpatter.model.discount.SemDesconto;

class TestaDescontos {
	private Orcamento orcamento;
	
	@BeforeEach
	public void configuraTeste() {
		this.orcamento = new Orcamento(new BigDecimal("1000").setScale(2),1);
	}

	@Test
	void calculaDescontoValorMaiorQueQuinhentos() {
		
		Desconto descontoValorMaiorQuinhentos = new DescontoValorMaiorQueQuinhentos(new SemDesconto());
		
		assertEquals(new BigDecimal("100").setScale(2), descontoValorMaiorQuinhentos.calculaDesconto(orcamento).setScale(2));
	}
	
	@Test
	void calculaDescontoQuantidadeItensMaiorQueCinco() {
		
		Desconto descontoQtItensMaior = new DescontoQuantidadeItensMaiorQueCinco(new SemDesconto());
		
		assertEquals(new BigDecimal("5").setScale(2), descontoQtItensMaior.calculaDesconto(
				new Orcamento(new BigDecimal("100").setScale(2),6)
				).setScale(2));
	}
	
	
	@Test
	void calculaDescontoEncadeadoQuantidadeItensMaiorQueCincoEValorMaiorQueQuinhentos() {
		
		Desconto descontoEncadeado = new DescontoQuantidadeItensMaiorQueCinco(
				new DescontoValorMaiorQueQuinhentos(
						new SemDesconto()
						) 
				);
		
		assertEquals(new BigDecimal("150").setScale(2), descontoEncadeado.calculaDesconto(
				new Orcamento(new BigDecimal("1000").setScale(2),6)
				).setScale(2));
	}
	
	@Test
	void calculaDescontoEncadeadoValorMaiorQueQuinhentosEQuantidadeItensMaiorQueCinco() {
		
		Desconto descontoEncadeado = new DescontoValorMaiorQueQuinhentos(
				new DescontoQuantidadeItensMaiorQueCinco(
						new SemDesconto()
						) 
				);
		
		assertEquals(new BigDecimal("150").setScale(2), descontoEncadeado.calculaDesconto(
				new Orcamento(new BigDecimal("1000").setScale(2),6)
				).setScale(2));
	}

}
