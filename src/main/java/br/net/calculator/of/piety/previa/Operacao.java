package br.net.calculator.of.piety.previa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Operacao {

	private BigDecimal valorOperacao;
	private LocalDate dataLiberacao;
	private BigDecimal taxa;
	private List<Parcela> parcelas;
	//private List<Pagamento> pagamentos;
	
	
/*
	public List<Pagamento> getPagamentos() {
		if (pagamentos == null) {
			pagamentos = new ArrayList<Pagamento>();
			
		}

		return pagamentos;
	}

	protected void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
*/


	public List<Parcela> getParcelas() {
		if (parcelas == null) {
			parcelas = new ArrayList<Parcela>();

		}

		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public LocalDate getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDate dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

}
