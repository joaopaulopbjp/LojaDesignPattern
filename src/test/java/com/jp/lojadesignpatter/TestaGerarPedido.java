package com.jp.lojadesignpatter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jp.lojadesignpatter.command.GerarPedido;
import com.jp.lojadesignpatter.exception.SituacaoException;
import com.jp.lojadesignpatter.model.budget.Orcamento;
import com.jp.lojadesignpatter.model.discount.Desconto;
import com.jp.lojadesignpatter.model.discount.DescontoQuantidadeItensMaiorQueCinco;
import com.jp.lojadesignpatter.model.discount.DescontoValorMaiorQueQuinhentos;
import com.jp.lojadesignpatter.model.discount.SemDesconto;
import com.jp.lojadesignpatter.model.order.Pedido;
import com.jp.lojadesignpatter.service.EmailServicePedido;
import com.jp.lojadesignpatter.service.ServicePedido;

class TestaGerarPedido {
	private Orcamento orcamento;
	private String clienteNome;
	private Pedido pedido;
	private GerarPedido comandoGerarPedido;
	
	@BeforeEach
	public void configuraTeste() {
		this.orcamento = new Orcamento(new BigDecimal("1000").setScale(2),1);
		this.clienteNome = "Fulano";
		this.pedido = new Pedido(this.clienteNome, LocalDateTime.now(), this.orcamento);
	}

	@Test
	public void testaGerarPedido() {
		ServicePedido emailService = new EmailServicePedido();
		this.comandoGerarPedido = new GerarPedido(this.pedido, Arrays.asList(emailService) );
		this.comandoGerarPedido.execute();
		assertEquals(1,emailService.getPedidosProcessados().size());
	}

	@Test
	public void testaDescontoExtraOrcamentoAprovado() {
		try {
			this.orcamento.aprovarOrcamento();	
		} catch (SituacaoException e) {
			fail();
		}
		assertEquals(new BigDecimal("980").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaDescontoExtraOrcamentoReprovado() {
		try {
			this.orcamento.reprovarOrcamento();	
		} catch (SituacaoException e) {
			fail();
		}
		assertEquals(new BigDecimal("1000").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaDescontoExtraOrcamentoFinalizadoAposReprovacao() {
		this.orcamento.reprovarOrcamento();	
		this.orcamento.finalizarOrcamento();	

		assertEquals(new BigDecimal("1000").setScale(2),orcamento.calculaDescontoExtra());
	}
	
	@Test
	public void testaSituacaoOrcamentoNovoDepoisFinalizado() {
		try {
			this.orcamento.finalizarOrcamento();	
		} catch (SituacaoException e) {
			assertEquals("Orcamento não pode ser finalizado.", e.getMessage());
		}
	}
}
