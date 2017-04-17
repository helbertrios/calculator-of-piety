package br.net.calculator.of.piety.calculator.previa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.previa.CronogramaBO;
import br.net.calculator.of.piety.previa.Operacao;
import br.net.calculator.of.piety.previa.Parcela;

public class PriceTest {

	




	@Test
	public void testDataVencimento4X() {

		int numParcela = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal taxa = new BigDecimal("0.0172");
		BigDecimal valorOperacao = new BigDecimal("12000");

		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);

		Operacao operacao = new Operacao();
		operacao.setDataLiberacao(dataLiberacao);
		operacao.setTaxa(taxa);
		operacao.setParcelas(listaParcelas);
		operacao.setValorOperacao(valorOperacao);

		c.calculaDetlheParcelaBaseadoPrice(operacao);

		System.out.println(listaParcelas.get(0).obterValorParcela());
		Assert.assertEquals("Parcela 1", listaParcelas.get(0).obterValorParcela().compareTo(new BigDecimal("3130.10009765625")), 0);
		Assert.assertEquals("Parcela 2", listaParcelas.get(1).obterValorParcela().compareTo(new BigDecimal("3130.10009765625")), 0);
		Assert.assertEquals("Parcela 3", listaParcelas.get(2).obterValorParcela().compareTo(new BigDecimal("3130.10009765625")), 0);
		Assert.assertEquals("Parcela 4",  listaParcelas.get(3).obterValorParcela().compareTo(new BigDecimal("3130.10009765625")), 0);

	}

	
}
