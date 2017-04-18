package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIDefaults.LazyInputMap;

import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;

public class DespesasOperacaoTO implements TO, ICalculoEncargos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786521532416625405L;

	private List<DetalheParcelaTO> detalhesParcela;
	private List<EncargoTO> encargosTO;
	
	

	@Override
	public List<EncargoTO> getEncargosTO() {
		if (encargosTO == null) {
			encargosTO = new ArrayList<EncargoTO>();
		}

		return encargosTO;
	}

	@Override
	public void setEncargosTO(List<EncargoTO> encargosTO) {
		this.encargosTO = encargosTO;
	}

	@Override
	public List<DetalheParcelaTO> getDetalhesParcela() {
		if (detalhesParcela == null) {
			detalhesParcela = new ArrayList<DetalheParcelaTO>();
		}

		return detalhesParcela;
	}

	@Override
	public void setDetalheParcela(List<DetalheParcelaTO> detalhesParcela) {
		this.detalhesParcela = detalhesParcela;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder(super.toString() + '\n');
		retorno.append("=======================================================" + '\n');
		for (DetalheParcelaTO detalheParcelaTO : detalhesParcela) {
			retorno.append("Detalhe Parcela.......: " + detalheParcelaTO );
		}
		
	
		retorno.append("=======================================================" + '\n');
		return retorno.toString();
	}

}
