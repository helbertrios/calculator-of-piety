package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;
import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.util.math.bigdecimal.util.OpcoesCalculo;

public class CalculadoraSac extends Calculadora {

	
	public CalculadoraSac(LocalDate dataLiberacao, Integer quantidadeParcela, BigDecimal valorOperacao, List<LocalDate> vencimentos, BigDecimal taxa) {
		super(EnumSistemaAmortizacao.SAC, dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
	}


	public CalculadoraSac(OperacaoTO operacaoTO) {
		super(EnumSistemaAmortizacao.SAC, operacaoTO);
	}



	@Override
	public BigDecimal getValorPrimeiraParcelaCapitalOperacao() {

		BigDecimal saldoDevedor = operacaoTO.getValorOperacao();
		Integer prazo = operacaoTO.getQuantidadeParcela();
		BigDecimal valorParcelaCapital = saldoDevedor.divide(new BigDecimal(prazo), OpcoesCalculo.MathContextPadrao);

		return valorParcelaCapital;
	}

	@Override
	public void calcularCapitalDeTodasParcelas() {
		
		BigDecimal valorParcelaCapital = getValorPrimeiraParcelaCapitalOperacao();

		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			DetalheParcelaTO principalTO = new DetalheParcelaTO(EnumTipoDetalheParcela.PRINCIPAL);

			principalTO.setValor(valorParcelaCapital);
			principalTO.setDescricao(EnumTipoDetalheParcela.PRINCIPAL.getDescricao());

			parcelaTO.getDetalhesParcela().add(principalTO);

		}
	}

}
