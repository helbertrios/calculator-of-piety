package br.net.calculator.of.piety.calculator.bo.cronograma;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.bo.cronograma.CronogramaOperacaoCreditoBO;
import br.net.calculator.of.piety.bo.data.CalcularDataVencimentoBO;
import br.net.calculator.of.piety.bo.taxa.TaxaBO;
import br.net.calculator.of.piety.pietyEnums.EnumMomentoCobrancaEncargo;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;

public class CronogramaOperacaoCreditoBOTest {

	

	@Test
	public void testValorJurosOperacaoPrice4X() {
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		
		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal valorOperacao = new BigDecimal("17500");

		List<EncargoTO> encargosTO = obterTaxaJurosParaParcela(new BigDecimal("0.019"));

		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);

		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas,  EnumSistemaAmortizacao.PRICE); 
		cronogramaParcelasBO.setEncargosParaTodasParcelas(operacaoTO,encargosTO );
		cronogramaParcelasBO.calcularPrincipal(operacaoTO);
		cronogramaParcelasBO.calcularEncargos(operacaoTO); 
	
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(EnumTipoLancamento.JUROS).doubleValue() , 332.50d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(EnumTipoLancamento.JUROS).doubleValue() , 251.71d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(EnumTipoLancamento.JUROS).doubleValue() , 169.38d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(EnumTipoLancamento.JUROS).doubleValue() , 85.49d, 0.01  );
		
			
	}
	
	@Test
	public void testValorJurosOperacaoSAC4X() {
		
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();

		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal valorOperacao = new BigDecimal("17500");

		List<EncargoTO> encargosTO = obterTaxaJurosParaParcela(new BigDecimal("0.0190"));
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas, EnumSistemaAmortizacao.SAC);
		cronogramaParcelasBO.setEncargosParaTodasParcelas(operacaoTO,encargosTO );
		cronogramaParcelasBO.calcularPrincipal(operacaoTO);
		cronogramaParcelasBO.calcularEncargos(operacaoTO); 
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(EnumTipoLancamento.JUROS).doubleValue() , 332.50d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(EnumTipoLancamento.JUROS).doubleValue() , 249.38d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(EnumTipoLancamento.JUROS).doubleValue() , 166.25d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(EnumTipoLancamento.JUROS).doubleValue() , 83.13, 0.01  );
		
			
	}

	private List<EncargoTO> obterTaxaJurosParaParcela(BigDecimal valor) {
		List<EncargoTO> encargosTO = new ArrayList<EncargoTO>();
		encargosTO.add(new EncargoTO(valor, EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		return encargosTO;
	}
	
	
	@Test
	public void test() {
		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();
		TaxaBO taxaBO = new TaxaBO();
		
		
		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal valorOperacao = new BigDecimal("17500");

		EncargoTO encargoTO1 = new EncargoTO(new BigDecimal("0.020"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS);
		encargoTO1.setDescricaoEncargo("Taxa de Juros");
		EncargoTO encargoTO11 = new EncargoTO(new BigDecimal("0.010"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.OUTROS);
		encargoTO11.setDescricaoEncargo("TR");
		encargoTO1.getEncargosTO().add(encargoTO11 );

		EncargoTO encargoTOOpercao = new EncargoTO(new BigDecimal("100.00"), EnumTipoValorEncargo.VALOR, EnumMomentoCobrancaEncargo.LIBERACAO, EnumTipoLancamento.OUTROS);
		
		EncargoTO encargoTO2 = new EncargoTO(new BigDecimal("0.010"), EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.OUTROS);
		encargoTO2.setDescricaoEncargo("Outro encargo");
		
		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas,  EnumSistemaAmortizacao.PRICE); 
		operacaoTO.getDespesasOperacao().getEncargosTO().add(encargoTO1);
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			parcelaTO.getEncargosTO().add(encargoTO1);
			parcelaTO.getEncargosTO().add(encargoTO2);
			parcelaTO.getEncargosTO().add(encargoTOOpercao);
			
		}


		
		cronogramaParcelasBO.calcularPrincipal(operacaoTO);
		cronogramaParcelasBO.calcularEncargos(operacaoTO);
		
		System.out.println(operacaoTO.toString());
	

	}


	@Test
	public void testDataVencimento4X() {
		CalcularDataVencimentoBO calcularDataVencimentoBO =  new CalcularDataVencimentoBO();
		CronogramaOperacaoCreditoBO cronogramaParcelasBO = new CronogramaOperacaoCreditoBO();

		int quantidadeParcelas = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal valorOperacao = new BigDecimal("12000");

		List<EncargoTO> encargosTO = obterTaxaJurosParaParcela(new BigDecimal("0.0172"));

		List<LocalDate> vencimentosParcelas = calcularDataVencimentoBO.obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(quantidadeParcelas, dataLiberacao);
		OperacaoTO operacaoTO =  cronogramaParcelasBO.montarCronograma(dataLiberacao, quantidadeParcelas, valorOperacao, vencimentosParcelas,  EnumSistemaAmortizacao.PRICE);
		
		cronogramaParcelasBO.setEncargosParaTodasParcelas(operacaoTO,encargosTO );
		cronogramaParcelasBO.calcularPrincipal(operacaoTO);
		cronogramaParcelasBO.calcularEncargos(operacaoTO); 
	
		Assert.assertEquals(operacaoTO.getParcelas().get(0).getValor(null).doubleValue() , 3130.10d, 0.01 );
		Assert.assertEquals(operacaoTO.getParcelas().get(1).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(2).getValor(null).doubleValue() , 3130.10d, 0.01  );
		Assert.assertEquals(operacaoTO.getParcelas().get(3).getValor(null).doubleValue() , 3130.10d, 0.01  );
		
		

	}

	
}
