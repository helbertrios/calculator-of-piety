package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.to.TO;

public class DadosOperacaoTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488364996656739835L;
	
	private double valorBruto;
	private double valorLiquido;
	private double valorOperacoesLiquidadas;
	private LocalDate dataLiberacao;
	private TaxaTO taxaFixa;
	private BigDecimal cetOperacao;
	private List<ParcelaOperacaoTO> parcelasOperacao;
	private List<DespesaTO> despesasOperacao;
	

	
	public BigDecimal getCetOperacao() {
		return cetOperacao;
	}
	public void setCetOperacao(BigDecimal cetOperacao) {
		this.cetOperacao = cetOperacao;
	}
	public List<DespesaTO> getDespesasOperacao() {
		if (despesasOperacao == null) {
			despesasOperacao = new ArrayList<DespesaTO>();
			
		}

		
		return despesasOperacao;
	}
	public void setDespesasOperacao(List<DespesaTO> despesasOperacao) {
		this.despesasOperacao = despesasOperacao;
	}
	public double getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public double getValorOperacoesLiquidadas() {
		return valorOperacoesLiquidadas;
	}
	public void setValorOperacoesLiquidadas(double valorOperacoesLiquidadas) {
		this.valorOperacoesLiquidadas = valorOperacoesLiquidadas;
	}

	public List<ParcelaOperacaoTO> getParcelasOperacao() {
		if (parcelasOperacao == null) {
			parcelasOperacao = new ArrayList<ParcelaOperacaoTO>();
		}
		return parcelasOperacao;
	}
	public void setParcelasOperacao(List<ParcelaOperacaoTO> parcelasOperacao) {
		this.parcelasOperacao = parcelasOperacao;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}
	public LocalDate getDataLiberacao() {
		return dataLiberacao;
	}
	public void setDataLiberacao(LocalDate dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}
	public TaxaTO getTaxaFixa() {
		return taxaFixa;
	}
	public void setTaxaFixa(TaxaTO taxaFixa) {
		this.taxaFixa = taxaFixa;
	}

	
	
	
	

}
