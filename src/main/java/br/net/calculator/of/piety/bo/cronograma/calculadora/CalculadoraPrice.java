package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.util.math.bigdecimal.util.OpcoesCalculo;

public class CalculadoraPrice extends Calculadora {
	
	public CalculadoraPrice(LocalDate dataLiberacao, Integer quantidadeParcela, BigDecimal valorOperacao, List<LocalDate> vencimentos) {
		super(EnumSistemaAmortizacao.PRICE, dataLiberacao, quantidadeParcela, valorOperacao, vencimentos);
	}


	public CalculadoraPrice(OperacaoTO operacaoTO) {
		super(EnumSistemaAmortizacao.PRICE, operacaoTO);
	}
	
	
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
	
	public BigDecimal obterTaxaEquivalenteUmPeriodoEntreParcelas( EnumTipoLancamento enumTipoLancamento) {
		BigDecimal taxa = new BigDecimal("0");
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			BigDecimal taxaAux = obterTaxa(parcelaTO.getEncargosTO(), EnumTipoLancamento.JUROS);
			taxa = taxa.add(taxaAux);
			
		}
		return taxa.divide(new BigDecimal(operacaoTO.getQuantidadeParcela()));
	}
	
	@Override
	public BigDecimal getValorPrimeiraParcelaCapitalOperacao() {
		BigDecimal taxa = obterTaxaEquivalenteUmPeriodoEntreParcelas(EnumTipoLancamento.JUROS);
		BigDecimal saldoDevedor = operacaoTO.getValorOperacao();
		BigDecimal umMaisTaxa = BigDecimal.ONE.add(taxa);
		Integer prazo = operacaoTO.getQuantidadeParcela();
		BigDecimal dividendo = umMaisTaxa.pow(prazo).multiply(taxa);
		BigDecimal divisor = umMaisTaxa.pow(prazo).subtract(BigDecimal.ONE);
		float fator = dividendo.floatValue() / divisor.floatValue();
		BigDecimal valorParcela = new BigDecimal(saldoDevedor.floatValue() * fator);
						
		return valorParcela.subtract(saldoDevedor.multiply(taxa, OpcoesCalculo.MathContextPadrao), OpcoesCalculo.MathContextPadrao);
		
	}
	
	
	
	public void calcularCapitalDeTodasParcelas() {
		
		BigDecimal valorParcelaCapital = this.getValorPrimeiraParcelaCapitalOperacao();
		BigDecimal taxa = obterTaxaEquivalenteUmPeriodoEntreParcelas(EnumTipoLancamento.JUROS);
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			DetalheParcelaTO principalTO = new DetalheParcelaTO(EnumTipoLancamento.PRINCIPAL);
			
			principalTO.setValor(valorParcelaCapital);
			principalTO.setDescricao(EnumTipoLancamento.PRINCIPAL.getDescricao());
			
			parcelaTO.getDetalhesParcela().add(principalTO);
			
			valorParcelaCapital = valorParcelaCapital.add(valorParcelaCapital.multiply(taxa));


		}

	}

}
