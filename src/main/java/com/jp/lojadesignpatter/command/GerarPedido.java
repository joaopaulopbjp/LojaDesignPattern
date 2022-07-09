package com.jp.lojadesignpatter.command;

import java.util.List;

import com.jp.lojadesignpatter.model.order.Pedido;
import com.jp.lojadesignpatter.service.ServicePedido;

public class GerarPedido implements Comandos {
	private List<ServicePedido> servicosPedido;
	private Pedido pedido;
	
	
	
	public GerarPedido(Pedido pedido, List<ServicePedido> servicosPedido) {
		this.pedido = pedido;
		this.servicosPedido = servicosPedido;
	}



	@Override
	public void execute() {
		servicosPedido.forEach(s -> s.executaServico(pedido));
	}

}
