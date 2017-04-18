package br.net.calculator.of.piety.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.bo.cronograma.calculadora.Calculadora;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.SistemaAmortizacao;

public class CronogramaOperacaoCreditoBO {

	public OperacaoTO montarCronograma(final LocalDate dataLiberacao, final Integer quantidadeParcela, final BigDecimal valorOperacao, final List<LocalDate> vencimentos, final BigDecimal taxa, final SistemaAmortizacao sistemaAmortizacao) {


		
		Calculadora calculadora = Calculadora.getInstancia(sistemaAmortizacao, dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
		
		return calculadora.getOperacaoTO();
	}



}
