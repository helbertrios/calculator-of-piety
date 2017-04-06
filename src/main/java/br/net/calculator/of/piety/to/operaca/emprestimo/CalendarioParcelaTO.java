package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.time.LocalDate;

import br.net.calculator.of.piety.to.TO;

public abstract class CalendarioParcelaTO implements TO {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1094376780138091646L;
	
	
	private LocalDate dataCobranca;


	public LocalDate getDataCobranca() {
		return dataCobranca;
	}


	public void setDataCobranca(LocalDate dataCobranca) {
		this.dataCobranca = dataCobranca;
	}
	
	

}
