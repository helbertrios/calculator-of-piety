package br.net.calculator.of.piety.calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.bo.cronograma.CronogramaOperacaoCreditoBO;
import br.net.calculator.of.piety.bo.data.CalcularDataVencimentoBO;
import br.net.calculator.of.piety.calculator.cet.CalculatorCET;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.to.cet.DadosEmprestimoCETTO;
import br.net.calculator.of.piety.to.cet.ParcelaCETTO;


public class CalculaOperacaoEmprestimo {

	public void calcularEmprestimo() {

		
		
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 05);
		Integer quantidadeParcelas = 24;
		BigDecimal valorOperacao = new BigDecimal("10000.00");
		double valorLiquido = 0d;
		BigDecimal taxa = new BigDecimal("0.020");

		CronogramaOperacaoCreditoBO cronogramaOperacaoCreditoBO =  new CronogramaOperacaoCreditoBO();
		CalcularDataVencimentoBO calcularDataVencimentoBO = new CalcularDataVencimentoBO();
		
		List<LocalDate> vencimentos = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		
		OperacaoTO operacaoTO =  cronogramaOperacaoCreditoBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentos, taxa, EnumSistemaAmortizacao.PRICE);
		
		valorLiquido = operacaoTO.getValorOperacao().floatValue();
		//obterValorOperacoesASeremLiquidadas();
		
		BigDecimal cet = apuraCet(valorLiquido, operacaoTO.getDataLiberacao(),
				operacaoTO.getParcelas());
		
		operacaoTO.setCet(cet);
		System.out.println(operacaoTO);
	}

	
	private BigDecimal obterValorOperacoesASeremLiquidadas() {
		return new BigDecimal("0.00");
		
	}

	private BigDecimal apuraCet(Double valorParaCet, LocalDate dataLiberacao,
			List<ParcelaTO> parcelasOperacao) {

		List<ParcelaCETTO> parcelaCETs = parcelaOperacaoToParcelaCET(parcelasOperacao);

		DadosEmprestimoCETTO dadosEmprestimoCET = new DadosEmprestimoCETTO();
		dadosEmprestimoCET.setDataLiberacao(dataLiberacao);
		dadosEmprestimoCET.setParcelasCet(parcelaCETs);
		dadosEmprestimoCET.setValorDaOperacaoParaCET(valorParaCet);

		return CalculatorCET.cetOperacao(dadosEmprestimoCET);
	}

	private List<ParcelaCETTO> parcelaOperacaoToParcelaCET(List<ParcelaTO> parcelasOperacao) {
		List<ParcelaCETTO> parcelaCETs = new ArrayList<ParcelaCETTO>();

		for (ParcelaTO parcelaOperacao : parcelasOperacao) {
			ParcelaCETTO parcelaCET = new ParcelaCETTO();
			parcelaCET.setDataCobranca(parcelaOperacao.getDataVencimento());
			parcelaCET.setValorParcela(parcelaOperacao.getValor(null));
			parcelaCETs.add(parcelaCET);
		}
		return parcelaCETs;
	}

	public static void main(String[] args) {
		CalculaOperacaoEmprestimo v = new CalculaOperacaoEmprestimo();
		v.calcularEmprestimo();
	}

	


}
