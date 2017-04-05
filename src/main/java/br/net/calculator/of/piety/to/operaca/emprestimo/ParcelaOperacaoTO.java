package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParcelaOperacaoTO extends CalendarioParcelaTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556084475920566701L;
	
	private BigDecimal valorParcela;
	private List<DespesaTO> despesasParcela;
	
	public List<DespesaTO> getDespesasParcela() {
		if (despesasParcela == null) {
			despesasParcela = new ArrayList<DespesaTO>();
		}
		return despesasParcela;
	}

	public void setDespesasParcela(List<DespesaTO> despesasParcela) {
		this.despesasParcela = despesasParcela;
	}


	public BigDecimal getValorParcela() {
		
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	
		
	
	
	

}
