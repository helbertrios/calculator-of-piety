package br.net.calculator.of.piety.to.cet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.to.TO;

public class DadosEmprestimoCETTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556084475920566701L;

	private List<ParcelaCETTO> parcelasCet;
	private LocalDate dataLiberacao;
	private double valorDaOperacaoParaCET;

	
	


	public List<ParcelaCETTO> getParcelasCet() {
		return parcelasCet;
	}

	public void setParcelasCet(List<ParcelaCETTO> parcelasCet) {
		this.parcelasCet = parcelasCet;
	}

	public LocalDate getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDate dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public double getValorDaOperacaoParaCET() {
		return valorDaOperacaoParaCET;
	}

	public void setValorDaOperacaoParaCET(double valorDaOperacaoParaCET) {
		this.valorDaOperacaoParaCET = valorDaOperacaoParaCET;
	}

	

}
