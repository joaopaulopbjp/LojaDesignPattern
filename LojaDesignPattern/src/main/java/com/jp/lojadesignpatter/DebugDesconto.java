package com.jp.lojadesignpatter;


import java.math.BigDecimal;

import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.discount.Desconto;
import com.jp.lojadesignpatter.model.discount.DescontoQuantidadeItensMaiorQueCinco;
import com.jp.lojadesignpatter.model.discount.DescontoValorMaiorQueQuinhentos;
import com.jp.lojadesignpatter.model.discount.SemDesconto;

public class DebugDesconto {

	public static void main(String[] args) {
		Desconto descontoEncadeado = new DescontoValorMaiorQueQuinhentos(
				new DescontoQuantidadeItensMaiorQueCinco(
						new SemDesconto()
						) 
				);
		Orcamento orcamento = new Orcamento(new BigDecimal("1000").setScale(2),6);
		
		BigDecimal descontoTotal =  descontoEncadeado.calculaDesconto(orcamento).setScale(2);
		System.out.println(descontoTotal);
	}

}
