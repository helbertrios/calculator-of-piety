package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.to.TO;

public class DadosOperacao implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488364996656739835L;
	
	private double valorBruto;
	private double valorLiquido;
	private double valorOperacoesLiquidadas;
	private LocalDate dataLiberacao;
	private Taxa taxaFixa;
	private Integer numeroParcelas; 
	private List<ParcelaOperacao> parcelasOperacao;
	private List<Despesa> despesasOperacao;
	

	
	public List<Despesa> getDespesasOperacao() {
		return despesasOperacao;
	}
	public void setDespesasOperacao(List<Despesa> despesasOperacao) {
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
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	public List<ParcelaOperacao> getParcelasOperacao() {
		if (parcelasOperacao == null) {
			parcelasOperacao = new ArrayList<ParcelaOperacao>();
		}
		return parcelasOperacao;
	}
	public void setParcelasOperacao(List<ParcelaOperacao> parcelasOperacao) {
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
	public Taxa getTaxaFixa() {
		return taxaFixa;
	}
	public void setTaxaFixa(Taxa taxaFixa) {
		this.taxaFixa = taxaFixa;
	}

	
	
	
	

}
