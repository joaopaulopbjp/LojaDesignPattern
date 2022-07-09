package com.jp.lojadesignpatter.service;

import java.util.ArrayList;
import java.util.List;

import com.jp.lojadesignpatter.model.order.Pedido;

public class EmailServicePedido implements ServicePedido {
	private List<Pedido> listaEmailEnviado;
	
	

	public EmailServicePedido() {
		this.listaEmailEnviado = new ArrayList<Pedido>();
	}



	@Override
	public void executaServico(Pedido pedido) {
		this.listaEmailEnviado.add(pedido);
	}



	public List<Pedido> getPedidosProcessados() {
		return listaEmailEnviado;
	}

}
