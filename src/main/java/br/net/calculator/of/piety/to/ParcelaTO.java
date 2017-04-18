package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParcelaTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786521532416625405L;
	
	private List<DetalheParcelaTO> detalhesParcela;
	private LocalDate dataVencimento;

	public BigDecimal getValor(TipoDetalheParcela tipoDetalhes) {
		
		BigDecimal saldoDevedor = new BigDecimal("0.00");
		
		for (DetalheParcelaTO detalheParcela : detalhesParcela) {

			if ( tipoDetalhes == null) {
				saldoDevedor = saldoDevedor.add(detalheParcela.getValor()); 
			} else if ( tipoDetalhes.equals(detalheParcela.getTipoDetalheParcela()) ) {
				saldoDevedor = saldoDevedor.add(detalheParcela.getValor()); 
			}
									
		}
		
		return saldoDevedor;

	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public List<DetalheParcelaTO> getDetalhesParcela() {
		if (detalhesParcela == null) {
			detalhesParcela = new ArrayList<DetalheParcelaTO>();

		}

		return detalhesParcela;
	}

	public void setDetalheParcela(List<DetalheParcelaTO> detalhesParcela) {
		this.detalhesParcela = detalhesParcela;
	}
	
	
	

}
