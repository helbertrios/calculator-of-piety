package br.net.calculator.of.piety.previa.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pagamento {
	
	private LocalDate dataPagamento;
	private PagamentoDetalhe pagamentoDetalhe;
	
	public BigDecimal getValorPagamentoJuros(){
		BigDecimal valorPagamento = new BigDecimal("0.00");
		//for (PagamentoDetalhe pagamentoDetalhe : pagamentosDetalhe) {
			valorPagamento = valorPagamento.add(pagamentoDetalhe.getValorPagoJuros());	
		//}
		return valorPagamento;
	}
	
	public BigDecimal getValorPagamentoPrincipal(){
		BigDecimal valorPagamento = new BigDecimal("0.00");
		//for (PagamentoDetalhe pagamentoDetalhe : pagamentosDetalhe) {
			valorPagamento = valorPagamento.add(pagamentoDetalhe.getValorPagoPrincipal());	
		//}
		return valorPagamento;
	}
	
	public BigDecimal getValorPagamento(){
		return getValorPagamentoPrincipal().add(getValorPagamentoJuros());
	}
	
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public PagamentoDetalhe getPagamentosDetalhe() {
		if (pagamentoDetalhe == null) {
			pagamentoDetalhe = new PagamentoDetalhe() ;
			
		}
		return pagamentoDetalhe;
	}
	public void setPagamentosDetalhe(PagamentoDetalhe pagamentoDetalhe) {
		this.pagamentoDetalhe = pagamentoDetalhe;
	}
	

}
