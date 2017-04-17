package br.net.calculator.of.piety.previa.pagamento;

import java.math.BigDecimal;

public class PagamentoDetalhe {
	
	private BigDecimal valorPagoJuros;
	private BigDecimal valorPagoPrincipal;
	private Pagamento pagamento;
	
	public BigDecimal getValorPagoJuros() {
		return valorPagoJuros;
	}
	public void setValorPagoJuros(BigDecimal valorPagoJuros) {
		this.valorPagoJuros = valorPagoJuros;
	}
	public BigDecimal getValorPagoPrincipal() {
		return valorPagoPrincipal;
	}
	public void setValorPagoPrincipal(BigDecimal valorPagoPrincipal) {
		this.valorPagoPrincipal = valorPagoPrincipal;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	


}
