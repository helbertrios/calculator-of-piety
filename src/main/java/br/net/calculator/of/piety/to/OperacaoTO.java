package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperacaoTO {

	private BigDecimal valorOperacao;
	private LocalDate dataLiberacao;
	private BigDecimal taxa;
	private Integer quantidadeParcela;
	private List<ParcelaTO> parcelas;
	private SistemaAmortizacao sistemaAmortizacao;

	public List<ParcelaTO> getParcelas() {
		if (parcelas == null) {
			parcelas = new ArrayList<ParcelaTO>();

		}

		return parcelas;
	}

	public void setParcelas(List<ParcelaTO> parcelas) {
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

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public SistemaAmortizacao getSistemaAmortizacao() {
		return sistemaAmortizacao;
	}

	public void setSistemaAmortizacao(SistemaAmortizacao sistemaAmortizacao) {
		this.sistemaAmortizacao = sistemaAmortizacao;
	}

}
