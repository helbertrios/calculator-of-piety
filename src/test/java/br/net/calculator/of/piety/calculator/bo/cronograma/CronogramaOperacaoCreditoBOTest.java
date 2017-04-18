package br.net.calculator.of.piety.calculator.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.bo.cronograma.CronogramaOperacaoCreditoBO;
import br.net.calculator.of.piety.bo.data.CalcularDataVencimentoBO;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;

public class CronogramaOperacaoCreditoBOTest {

	




	@Test
	public void testDataVencimento4X() {

		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		
		BigDecimal taxa = new BigDecimal("0.0172");
		BigDecimal valorOperacao = new BigDecimal("12000");

		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		System.out.println("Teste");
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas, taxa, EnumSistemaAmortizacao.PRICE); 
		
		for (ParcelaTO parcela : operacaoTO.getParcelas()) {
			System.out.println("=======================================================");
			System.out.println("");
			System.out.println("Vencimento.......: " + parcela.getDataVencimento());
			for (DetalheParcelaTO detalheParcela : parcela.getDetalhesParcela()) {
				System.out.println("......==================================================");
				System.out.println("......Valor ..................: " + detalheParcela.getValor());
				System.out.println("......Tipo. ..................: " + detalheParcela.getDescricao());
				System.out.println("......=================================================");
			}
			System.out.println("Valor Parcela....: " + parcela.getValor(null));
		}
		
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(null).doubleValue() , 3130.10d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(null).doubleValue() , 3130.10d, 0.01  );
		
		

	}

	
}
