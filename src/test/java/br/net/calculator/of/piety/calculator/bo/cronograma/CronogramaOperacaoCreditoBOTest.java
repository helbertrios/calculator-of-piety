package br.net.calculator.of.piety.calculator.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.bo.cronograma.CronogramaOperacaoCreditoBO;
import br.net.calculator.of.piety.bo.data.CalcularDataVencimentoBO;
import br.net.calculator.of.piety.pietyEnums.EnumMomentoCobrancaEncargo;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;

public class CronogramaOperacaoCreditoBOTest {

	

	@Test
	public void testValorJurosOperacaoPrice4X() {
		
		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		
		BigDecimal taxa = new BigDecimal("0.0190");
		BigDecimal valorOperacao = new BigDecimal("17500");

		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas, taxa, EnumSistemaAmortizacao.PRICE); 
		
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 332.50d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 251.71d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 169.38d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 85.49d, 0.01  );
		
			
	}
	
	@Test
	public void testValorJurosOperacaoSAC4X() {
		
		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal taxa = new BigDecimal("0.0190");
		BigDecimal valorOperacao = new BigDecimal("17500");


		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		
		
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas, taxa, EnumSistemaAmortizacao.SAC); 
	
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 332.50d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 249.38d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 166.25d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(EnumTipoDetalheParcela.JUROS).doubleValue() , 83.13, 0.01  );
		
			
	}
	
	
	@Test
	public void test() {
		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
			
		
		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal valorOperacao = new BigDecimal("17500");
		BigDecimal taxa = new BigDecimal("0.0179");
		List<LocalDate> vencimentos = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);

		EncargoTO juros = new EncargoTO(new BigDecimal("0.020"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoDetalheParcela.JUROS);
		juros.setDescricaoEncargo("Taxa de Juros");
		EncargoTO indexador = new EncargoTO(new BigDecimal("0.010"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoDetalheParcela.INDEXADOR);
		indexador.setDescricaoEncargo("TR");
		juros.getEncargosTO().add(indexador);

		EncargoTO despesaEmissaoTituloParaPagamento = new EncargoTO(new BigDecimal("10.00"), EnumTipoValorEncargo.VALOR, EnumMomentoCobrancaEncargo.LIBERACAO, EnumTipoDetalheParcela.OUTROS);
	
		EncargoTO taxaAdministacao = new EncargoTO(new BigDecimal("0.010"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoDetalheParcela.OUTROS);
		taxaAdministacao.setDescricaoEncargo("Outro encargo");
		
		
		
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentos, taxa, EnumSistemaAmortizacao.PRICE); 
		operacaoTO.getDespesasOperacao().getEncargosTO().add(juros);
		
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			parcelaTO.getEncargosTO().add(juros);
			parcelaTO.getEncargosTO().add(taxaAdministacao);
			parcelaTO.getEncargosTO().add(despesaEmissaoTituloParaPagamento);
			
		}


		
		cronogramaParcelasBO.calcularPrincipal(operacaoTO);
		cronogramaParcelasBO.calcularEncargos(operacaoTO);
		
		System.out.println(operacaoTO.toString());
	

	}


	@Test
	public void testDataVencimento4X() {

		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		
		BigDecimal taxa = new BigDecimal("0.0172");
		BigDecimal valorOperacao = new BigDecimal("12000");

		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas, taxa, EnumSistemaAmortizacao.PRICE); 
		
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(null).doubleValue() , 3130.10d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(null).doubleValue() , 3130.10d, 0.01  );
		
		

	}

	
}
