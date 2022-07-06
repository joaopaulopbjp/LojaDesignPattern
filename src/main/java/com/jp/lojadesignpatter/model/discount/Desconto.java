package com.jp.lojadesignpatter.model.discount;

import java.math.BigDecimal;
import java.util.Optional;

import com.jp.lojadesignpatter.model.budget.Orcamento;


public abstract class Desconto {

	protected Desconto next;
	
	
	
	public Desconto(Desconto next) {
		this.next = next;
	}


	public BigDecimal calculaDesconto(Orcamento orcamento) {
		BigDecimal somaDescontos = BigDecimal.ZERO;
		
		if(verificaDesconto(orcamento)) {
			BigDecimal descontoEfetuado = efetuaRegraDesconto(orcamento);
			somaDescontos = somaDescontos.add(descontoEfetuado);
		}
		
		if(next != null) {
			return somaDescontos.add(next.calculaDesconto(orcamento));	
		}
	
		return somaDescontos;
	}

	public abstract BigDecimal efetuaRegraDesconto(Orcamento orcamento) ;
	
	public abstract boolean verificaDesconto(Orcamento orcamento);
}
