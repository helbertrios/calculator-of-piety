package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.to.TipoDetalheParcela;
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
	void calcularCapitalDeTodasParcelas() {
		
		BigDecimal valorParcelaCapital = getValorPrimeiraParcelaCapitalOperacao();

		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			DetalheParcelaTO principalTO = new DetalheParcelaTO(TipoDetalheParcela.PRINCIPAL);

			principalTO.setValor(valorParcelaCapital);
			principalTO.setDescricao(TipoDetalheParcela.PRINCIPAL.getDescricao());

			parcelaTO.getDetalhesParcela().add(principalTO);

		}
	}

}
