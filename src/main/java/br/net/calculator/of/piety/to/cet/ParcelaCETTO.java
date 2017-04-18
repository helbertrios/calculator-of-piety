package br.net.calculator.of.piety.to.cet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ParcelaCETTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556084475920566701L;
	
	private LocalDate dataCobranca;
	private BigDecimal valorParcela;


	
	
	public LocalDate getDataCobranca() {
		return dataCobranca;
	}


	public void setDataCobranca(LocalDate dataCobranca) {
		this.dataCobranca = dataCobranca;
	}


	public BigDecimal getValorParcela() {
		return valorParcela;
	}


	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	


	
	
	
}
