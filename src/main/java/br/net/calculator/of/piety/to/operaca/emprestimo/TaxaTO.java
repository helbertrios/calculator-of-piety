package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.math.BigDecimal;

import br.net.calculator.of.piety.to.TO;

public class TaxaTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1737683779405387654L;
	private BigDecimal pecentualTaxa;
	
	public BigDecimal getPecentualTaxa() {
		if (pecentualTaxa == null) {
			pecentualTaxa = new BigDecimal("0.00");
		}
		return pecentualTaxa;
	}
	
	public void setPecentualTaxa(BigDecimal pecentualTaxa) {
		this.pecentualTaxa = pecentualTaxa;
	}
	
	

}
