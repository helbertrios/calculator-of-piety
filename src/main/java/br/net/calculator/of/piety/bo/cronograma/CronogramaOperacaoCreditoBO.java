package br.net.calculator.of.piety.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.net.calculator.of.piety.bo.cronograma.calculadora.Calculadora;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;

public class CronogramaOperacaoCreditoBO {

	public OperacaoTO montarCronograma(final LocalDate dataLiberacao, final Integer quantidadeParcelas, final BigDecimal valorOperacao, final List<LocalDate> vencimentos, final EnumSistemaAmortizacao sistemaAmortizacao) {

		Calculadora calculadora = Calculadora.getInstancia(sistemaAmortizacao, dataLiberacao, quantidadeParcelas, valorOperacao, vencimentos);
		
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

	public void setEncargosParaTodasParcelas(OperacaoTO operacaoTO, List<EncargoTO> encargosTO) {
		
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			parcelaTO.getEncargosTO().addAll(encargosTO);
			
		}
		
	}
	


}
