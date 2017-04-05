package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.math.BigDecimal;
import java.util.List;

public class ParcelaOperacao extends CalendarioParcela {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556084475920566701L;
	
	private BigDecimal valorParcela;
	private List<Despesa> despesasParcela;
	
	public List<Despesa> getDespesasParcela() {
		return despesasParcela;
	}

	public void setDespesasParcela(List<Despesa> despesasParcela) {
		this.despesasParcela = despesasParcela;
	}


	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	
		
	
	
	

}
