package com.jp.lojadesignpatter.service;

import java.util.List;

import com.jp.lojadesignpatter.model.order.Pedido;

public interface ServicePedido {

	public void executaServico(Pedido pedido);
	public List<Pedido> getPedidosProcessados();
}
