package br.net.calculator.of.piety.bo.taxa;

import java.math.BigDecimal;
import java.util.List;
import java.util.spi.TimeZoneNameProvider;

import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.EncargoTO;

public class TaxaBO {

	public BigDecimal obterTaxa(List<EncargoTO> encargosTO, EnumTipoLancamento enumTipoLancamento) {
		BigDecimal valorTaxa = new BigDecimal("0.00");
		for (EncargoTO encargoTO : encargosTO) {
			BigDecimal valorTaxaAux = obterTaxa(encargoTO.getEncargosTO(), enumTipoLancamento);
			if (enumTipoLancamento == null || enumTipoLancamento.equals(encargoTO.getTipoDetalheParcela())) {
				if (encargoTO.getTipoValorEncargo().equals(EnumTipoValorEncargo.PERCENTUAL)) {
					valorTaxa = valorTaxa.add(encargoTO.getTaxaEncargo().multiply(valorTaxaAux).add(valorTaxaAux)
							.add(encargoTO.getTaxaEncargo()));
				} else {
					valorTaxa = valorTaxa.add(valorTaxaAux);
				}
			}
		}
		return valorTaxa;
	}

}
