package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.to.SistemaAmortizacao;
import br.net.calculator.of.piety.to.TipoDetalheParcela;
import br.net.calculator.of.piety.util.math.bigdecimal.util.OpcoesCalculo;

public class CalculadoraPrice extends Calculadora {

	
	public CalculadoraPrice(LocalDate dataLiberacao, Integer quantidadeParcela, BigDecimal valorOperacao, List<LocalDate> vencimentos, BigDecimal taxa) {
		super(SistemaAmortizacao.PRICE, dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
	}


	public CalculadoraPrice(OperacaoTO operacaoTO) {
		super(SistemaAmortizacao.PRICE, operacaoTO);
	}
	
	@Override
	public BigDecimal getValorPrimeiraParcelaCapitalOperacao() {
		
		BigDecimal saldoDevedor = operacaoTO.getValorOperacao();
		BigDecimal umMaisTaxa = BigDecimal.ONE.add(operacaoTO.getTaxa());
		Integer prazo = operacaoTO.getQuantidadeParcela();
		BigDecimal dividendo = umMaisTaxa.pow(prazo).multiply(operacaoTO.getTaxa());
		BigDecimal divisor = umMaisTaxa.pow(prazo).subtract(BigDecimal.ONE);
		float fator = dividendo.floatValue() / divisor.floatValue();
		BigDecimal valorParcela = new BigDecimal(saldoDevedor.floatValue() * fator);
						
		return valorParcela.subtract(saldoDevedor.multiply(operacaoTO.getTaxa(), OpcoesCalculo.MathContextPadrao), OpcoesCalculo.MathContextPadrao);
		
	}
	
	
	@Override
	void calcularCapitalDeTodasParcelas() {
		
		BigDecimal valorParcelaCapital = this.getValorPrimeiraParcelaCapitalOperacao();
		
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			DetalheParcelaTO principalTO = new DetalheParcelaTO(TipoDetalheParcela.PRINCIPAL);
			
			principalTO.setValor(valorParcelaCapital);
			principalTO.setDescricao(TipoDetalheParcela.PRINCIPAL.getDescricao());
			
			parcelaTO.getDetalhesParcela().add(principalTO);
			
			valorParcelaCapital = valorParcelaCapital.add(valorParcelaCapital.multiply(operacaoTO.getTaxa()));


		}

	}

}
