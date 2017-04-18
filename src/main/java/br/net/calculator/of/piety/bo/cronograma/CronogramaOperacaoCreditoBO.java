package br.net.calculator.of.piety.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.bo.cronograma.calculadora.Calculadora;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.to.OperacaoTO;

public class CronogramaOperacaoCreditoBO {

	public OperacaoTO montarCronograma(final LocalDate dataLiberacao, final Integer quantidadeParcelas, final BigDecimal valorOperacao, final List<LocalDate> vencimentos, final BigDecimal taxa, final EnumSistemaAmortizacao sistemaAmortizacao) {

		Calculadora calculadora = Calculadora.getInstancia(sistemaAmortizacao, dataLiberacao, quantidadeParcelas, valorOperacao, vencimentos, taxa);
		
		return calculadora.getOperacaoTO();
	}
	
	
	public OperacaoTO calcularEncargos(OperacaoTO operacaoTO) {
		
		Calculadora calculadora = Calculadora.getInstancia(operacaoTO.getSistemaAmortizacao(), operacaoTO);
		calculadora.calcularEncargosOperacao();
		calculadora.calcularEncargosParcela();
		
		return calculadora.getOperacaoTO();
	}

	
	public OperacaoTO calcularPrincipal(OperacaoTO operacaoTO) {
		
		Calculadora calculadora = Calculadora.getInstancia(operacaoTO.getSistemaAmortizacao(), operacaoTO);
		
		calculadora.calcularCapitalDeTodasParcelas();
		
		
		return calculadora.getOperacaoTO();
	}



}
