package com.jp.lojadesignpatter.model.order;

import java.time.LocalDateTime;

import com.jp.lojadesignpatter.model.budget.Orcamento;

public class Pedido {
	private String nomeCliente;
	private LocalDateTime data;
	private Orcamento orcamento;
	
	public Pedido(String nomeCliente, LocalDateTime data, Orcamento orcamento) {
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.orcamento = orcamento;
	}
	
	

}
