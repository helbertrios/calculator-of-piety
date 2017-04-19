package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;

public class ParcelaTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786521532416625405L;
	
	private List<DetalheParcelaTO> detalhesParcela;
	private LocalDate dataVencimento;
	private List<EncargoTO> encargosTO;
	
	
	public List<EncargoTO> getEncargosTO() {
		if (encargosTO == null) {
			encargosTO = new ArrayList<EncargoTO>(0);

		}

		return encargosTO;
	}
	public void setEncargosTO(List<EncargoTO> encargosTO) {
		this.encargosTO = encargosTO;
	}

	public BigDecimal getValor(EnumTipoLancamento tipoDetalhes) {
		
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
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder(super.toString() + '\n');
		retorno.append("=======================================================" + '\n');
		retorno.append("Vencimento.......: " + getDataVencimento() + '\n');
		retorno.append("Valor Parcela.......: " + getValor(null) + '\n');
		for (DetalheParcelaTO detalheParcelaTO : detalhesParcela) {
			retorno.append("Detalhe Parcela.......: " + detalheParcelaTO );
		}
		
		for (EncargoTO encargoTO : encargosTO) {
			retorno.append("Encargos Parcela.......: " + encargoTO );
		}
		retorno.append("=======================================================" + '\n');
		return retorno.toString();
	}
	
	
	

}
