package br.net.calculator.of.piety.calculator.previa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.previa.CronogramaBO;
import br.net.calculator.of.piety.previa.Parcela;

public class CronogramaPagamentoTest {



	@Test
	public void testCriou4ParcelasNoCronograma() {
		int numParcela = 4;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);

		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
	}

	@Test
	public void testCriou10ParcelasNoCronograma() {
		int numParcela = 10;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);

		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
	}

	@Test
	public void testCriouQtdParcelasNoCronograma() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);
		for (int i = 1; i < 180; i++) {
			CronogramaBO c = new CronogramaBO();
			List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(i, dataLiberacao);
			Assert.assertEquals(i, listaParcelas.size());

		}
	}

	@Test
	public void testDataVencimento4X() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);
		int numParcela = 4;
		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
		Assert.assertEquals(listaParcelas.get(0).getDataVencimento().compareTo(LocalDate.of(2017, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(1).getDataVencimento().compareTo(LocalDate.of(2017, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(2).getDataVencimento().compareTo(LocalDate.of(2017, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(3).getDataVencimento().compareTo(LocalDate.of(2017, Month.MAY, 10)) , 0 );

	}

	
	@Test
	public void testDataVencimento12X() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);
		int numParcela =12;
		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
		Assert.assertEquals(listaParcelas.get(0).getDataVencimento().compareTo(LocalDate.of(2017, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(1).getDataVencimento().compareTo(LocalDate.of(2017, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(2).getDataVencimento().compareTo(LocalDate.of(2017, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(3).getDataVencimento().compareTo(LocalDate.of(2017, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(4).getDataVencimento().compareTo(LocalDate.of(2017, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(5).getDataVencimento().compareTo(LocalDate.of(2017, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(6).getDataVencimento().compareTo(LocalDate.of(2017, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(7).getDataVencimento().compareTo(LocalDate.of(2017, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(8).getDataVencimento().compareTo(LocalDate.of(2017, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(9).getDataVencimento().compareTo(LocalDate.of(2017, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(10).getDataVencimento().compareTo(LocalDate.of(2017, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(11).getDataVencimento().compareTo(LocalDate.of(2018, Month.JANUARY, 10)) , 0 );


	}
	
	@Test
	public void testDataVencimento60X() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 10);
		int numParcela =60;
		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
		Assert.assertEquals(listaParcelas.get(0).getDataVencimento().compareTo(LocalDate.of(2017, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(1).getDataVencimento().compareTo(LocalDate.of(2017, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(2).getDataVencimento().compareTo(LocalDate.of(2017, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(3).getDataVencimento().compareTo(LocalDate.of(2017, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(4).getDataVencimento().compareTo(LocalDate.of(2017, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(5).getDataVencimento().compareTo(LocalDate.of(2017, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(6).getDataVencimento().compareTo(LocalDate.of(2017, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(7).getDataVencimento().compareTo(LocalDate.of(2017, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(8).getDataVencimento().compareTo(LocalDate.of(2017, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(9).getDataVencimento().compareTo(LocalDate.of(2017, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(10).getDataVencimento().compareTo(LocalDate.of(2017, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(11).getDataVencimento().compareTo(LocalDate.of(2018, Month.JANUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(12).getDataVencimento().compareTo(LocalDate.of(2018, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(13).getDataVencimento().compareTo(LocalDate.of(2018, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(14).getDataVencimento().compareTo(LocalDate.of(2018, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(15).getDataVencimento().compareTo(LocalDate.of(2018, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(16).getDataVencimento().compareTo(LocalDate.of(2018, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(17).getDataVencimento().compareTo(LocalDate.of(2018, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(18).getDataVencimento().compareTo(LocalDate.of(2018, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(19).getDataVencimento().compareTo(LocalDate.of(2018, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(20).getDataVencimento().compareTo(LocalDate.of(2018, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(21).getDataVencimento().compareTo(LocalDate.of(2018, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(22).getDataVencimento().compareTo(LocalDate.of(2018, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(23).getDataVencimento().compareTo(LocalDate.of(2019, Month.JANUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(24).getDataVencimento().compareTo(LocalDate.of(2019, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(25).getDataVencimento().compareTo(LocalDate.of(2019, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(26).getDataVencimento().compareTo(LocalDate.of(2019, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(27).getDataVencimento().compareTo(LocalDate.of(2019, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(28).getDataVencimento().compareTo(LocalDate.of(2019, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(29).getDataVencimento().compareTo(LocalDate.of(2019, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(30).getDataVencimento().compareTo(LocalDate.of(2019, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(31).getDataVencimento().compareTo(LocalDate.of(2019, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(32).getDataVencimento().compareTo(LocalDate.of(2019, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(33).getDataVencimento().compareTo(LocalDate.of(2019, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(34).getDataVencimento().compareTo(LocalDate.of(2019, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(35).getDataVencimento().compareTo(LocalDate.of(2020, Month.JANUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(36).getDataVencimento().compareTo(LocalDate.of(2020, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(37).getDataVencimento().compareTo(LocalDate.of(2020, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(38).getDataVencimento().compareTo(LocalDate.of(2020, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(39).getDataVencimento().compareTo(LocalDate.of(2020, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(40).getDataVencimento().compareTo(LocalDate.of(2020, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(41).getDataVencimento().compareTo(LocalDate.of(2020, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(42).getDataVencimento().compareTo(LocalDate.of(2020, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(43).getDataVencimento().compareTo(LocalDate.of(2020, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(44).getDataVencimento().compareTo(LocalDate.of(2020, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(45).getDataVencimento().compareTo(LocalDate.of(2020, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(46).getDataVencimento().compareTo(LocalDate.of(2020, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(47).getDataVencimento().compareTo(LocalDate.of(2021, Month.JANUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(48).getDataVencimento().compareTo(LocalDate.of(2021, Month.FEBRUARY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(49).getDataVencimento().compareTo(LocalDate.of(2021, Month.MARCH, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(50).getDataVencimento().compareTo(LocalDate.of(2021, Month.APRIL, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(51).getDataVencimento().compareTo(LocalDate.of(2021, Month.MAY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(52).getDataVencimento().compareTo(LocalDate.of(2021, Month.JUNE, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(53).getDataVencimento().compareTo(LocalDate.of(2021, Month.JULY, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(54).getDataVencimento().compareTo(LocalDate.of(2021, Month.AUGUST, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(55).getDataVencimento().compareTo(LocalDate.of(2021, Month.SEPTEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(56).getDataVencimento().compareTo(LocalDate.of(2021, Month.OCTOBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(57).getDataVencimento().compareTo(LocalDate.of(2021, Month.NOVEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(58).getDataVencimento().compareTo(LocalDate.of(2021, Month.DECEMBER, 10)) , 0 );
		Assert.assertEquals(listaParcelas.get(59).getDataVencimento().compareTo(LocalDate.of(2022, Month.JANUARY, 10)) , 0 );


	}

	
	@Test
	public void testDataVencimento60XUltimodiaMes() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 31);
		int numParcela =60;
		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		Assert.assertEquals(numParcela, listaParcelas.size());
		Assert.assertEquals("Parcela 1", listaParcelas.get(0).getDataVencimento().compareTo(LocalDate.of(2017, Month.FEBRUARY, 28)) , 0 );
		Assert.assertEquals("Parcela 2", listaParcelas.get(1).getDataVencimento().compareTo(LocalDate.of(2017, Month.MARCH, 31)) , 0 );
		Assert.assertEquals("Parcela 3", listaParcelas.get(2).getDataVencimento().compareTo(LocalDate.of(2017, Month.APRIL, 30)) , 0 );
		Assert.assertEquals("Parcela 4", listaParcelas.get(3).getDataVencimento().compareTo(LocalDate.of(2017, Month.MAY, 31)) , 0 );
		Assert.assertEquals("Parcela 5", listaParcelas.get(4).getDataVencimento().compareTo(LocalDate.of(2017, Month.JUNE, 30)) , 0 );
		Assert.assertEquals("Parcela 6", listaParcelas.get(5).getDataVencimento().compareTo(LocalDate.of(2017, Month.JULY, 31)) , 0 );
		Assert.assertEquals("Parcela 7", listaParcelas.get(6).getDataVencimento().compareTo(LocalDate.of(2017, Month.AUGUST, 31)) , 0 );
		Assert.assertEquals("Parcela 8", listaParcelas.get(7).getDataVencimento().compareTo(LocalDate.of(2017, Month.SEPTEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 9", listaParcelas.get(8).getDataVencimento().compareTo(LocalDate.of(2017, Month.OCTOBER, 31)) , 0 );
		Assert.assertEquals("Parcela 10", listaParcelas.get(9).getDataVencimento().compareTo(LocalDate.of(2017, Month.NOVEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 11", listaParcelas.get(10).getDataVencimento().compareTo(LocalDate.of(2017, Month.DECEMBER, 31)) , 0 );
		Assert.assertEquals("Parcela 12", listaParcelas.get(11).getDataVencimento().compareTo(LocalDate.of(2018, Month.JANUARY, 31)) , 0 );
		Assert.assertEquals("Parcela 13", listaParcelas.get(12).getDataVencimento().compareTo(LocalDate.of(2018, Month.FEBRUARY, 28)) , 0 );
		Assert.assertEquals("Parcela 14", listaParcelas.get(13).getDataVencimento().compareTo(LocalDate.of(2018, Month.MARCH, 31)) , 0 );
		Assert.assertEquals("Parcela 15", listaParcelas.get(14).getDataVencimento().compareTo(LocalDate.of(2018, Month.APRIL, 30)) , 0 );
		Assert.assertEquals("Parcela 16", listaParcelas.get(15).getDataVencimento().compareTo(LocalDate.of(2018, Month.MAY, 31)) , 0 );
		Assert.assertEquals("Parcela 17", listaParcelas.get(16).getDataVencimento().compareTo(LocalDate.of(2018, Month.JUNE, 30)) , 0 );
		Assert.assertEquals("Parcela 18", listaParcelas.get(17).getDataVencimento().compareTo(LocalDate.of(2018, Month.JULY, 31)) , 0 );
		Assert.assertEquals("Parcela 19", listaParcelas.get(18).getDataVencimento().compareTo(LocalDate.of(2018, Month.AUGUST, 31)) , 0 );
		Assert.assertEquals("Parcela 20", listaParcelas.get(19).getDataVencimento().compareTo(LocalDate.of(2018, Month.SEPTEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 21", listaParcelas.get(20).getDataVencimento().compareTo(LocalDate.of(2018, Month.OCTOBER, 31)) , 0 );
		Assert.assertEquals("Parcela 22", listaParcelas.get(21).getDataVencimento().compareTo(LocalDate.of(2018, Month.NOVEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 23", listaParcelas.get(22).getDataVencimento().compareTo(LocalDate.of(2018, Month.DECEMBER, 31)) , 0 );
		Assert.assertEquals("Parcela 24", listaParcelas.get(23).getDataVencimento().compareTo(LocalDate.of(2019, Month.JANUARY, 31)) , 0 );
		Assert.assertEquals("Parcela 25", listaParcelas.get(24).getDataVencimento().compareTo(LocalDate.of(2019, Month.FEBRUARY, 28)) , 0 );
		Assert.assertEquals("Parcela 26", listaParcelas.get(25).getDataVencimento().compareTo(LocalDate.of(2019, Month.MARCH, 31)) , 0 );
		Assert.assertEquals("Parcela 27", listaParcelas.get(26).getDataVencimento().compareTo(LocalDate.of(2019, Month.APRIL, 30)) , 0 );
		Assert.assertEquals("Parcela 28", listaParcelas.get(27).getDataVencimento().compareTo(LocalDate.of(2019, Month.MAY, 31)) , 0 );
		Assert.assertEquals("Parcela 29", listaParcelas.get(28).getDataVencimento().compareTo(LocalDate.of(2019, Month.JUNE, 30)) , 0 );
		Assert.assertEquals("Parcela 30", listaParcelas.get(29).getDataVencimento().compareTo(LocalDate.of(2019, Month.JULY, 31)) , 0 );
		Assert.assertEquals("Parcela 31", listaParcelas.get(30).getDataVencimento().compareTo(LocalDate.of(2019, Month.AUGUST, 31)) , 0 );
		Assert.assertEquals("Parcela 32", listaParcelas.get(31).getDataVencimento().compareTo(LocalDate.of(2019, Month.SEPTEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 33", listaParcelas.get(32).getDataVencimento().compareTo(LocalDate.of(2019, Month.OCTOBER, 31)) , 0 );
		Assert.assertEquals("Parcela 34", listaParcelas.get(33).getDataVencimento().compareTo(LocalDate.of(2019, Month.NOVEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 35", listaParcelas.get(34).getDataVencimento().compareTo(LocalDate.of(2019, Month.DECEMBER, 31)) , 0 );
		Assert.assertEquals("Parcela 36", listaParcelas.get(35).getDataVencimento().compareTo(LocalDate.of(2020, Month.JANUARY, 31)) , 0 );
		Assert.assertEquals("Parcela 37", listaParcelas.get(36).getDataVencimento().compareTo(LocalDate.of(2020, Month.FEBRUARY, 29)) , 0 );
		Assert.assertEquals("Parcela 38", listaParcelas.get(37).getDataVencimento().compareTo(LocalDate.of(2020, Month.MARCH, 31)) , 0 );
		Assert.assertEquals("Parcela 39", listaParcelas.get(38).getDataVencimento().compareTo(LocalDate.of(2020, Month.APRIL, 30)) , 0 );
		Assert.assertEquals("Parcela 40", listaParcelas.get(39).getDataVencimento().compareTo(LocalDate.of(2020, Month.MAY, 31)) , 0 );
		Assert.assertEquals("Parcela 41", listaParcelas.get(40).getDataVencimento().compareTo(LocalDate.of(2020, Month.JUNE, 30)) , 0 );
		Assert.assertEquals("Parcela 42", listaParcelas.get(41).getDataVencimento().compareTo(LocalDate.of(2020, Month.JULY, 31)) , 0 );
		Assert.assertEquals("Parcela 43", listaParcelas.get(42).getDataVencimento().compareTo(LocalDate.of(2020, Month.AUGUST, 31)) , 0 );
		Assert.assertEquals("Parcela 44", listaParcelas.get(43).getDataVencimento().compareTo(LocalDate.of(2020, Month.SEPTEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 45", listaParcelas.get(44).getDataVencimento().compareTo(LocalDate.of(2020, Month.OCTOBER, 31)) , 0 );
		Assert.assertEquals("Parcela 46", listaParcelas.get(45).getDataVencimento().compareTo(LocalDate.of(2020, Month.NOVEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 47", listaParcelas.get(46).getDataVencimento().compareTo(LocalDate.of(2020, Month.DECEMBER, 31)) , 0 );
		Assert.assertEquals("Parcela 48", listaParcelas.get(47).getDataVencimento().compareTo(LocalDate.of(2021, Month.JANUARY, 31)) , 0 );
		Assert.assertEquals("Parcela 49", listaParcelas.get(48).getDataVencimento().compareTo(LocalDate.of(2021, Month.FEBRUARY, 28)) , 0 );
		Assert.assertEquals("Parcela 50", listaParcelas.get(49).getDataVencimento().compareTo(LocalDate.of(2021, Month.MARCH, 31)) , 0 );
		Assert.assertEquals("Parcela 51", listaParcelas.get(50).getDataVencimento().compareTo(LocalDate.of(2021, Month.APRIL, 30)) , 0 );
		Assert.assertEquals("Parcela 52", listaParcelas.get(51).getDataVencimento().compareTo(LocalDate.of(2021, Month.MAY, 31)) , 0 );
		Assert.assertEquals("Parcela 53", listaParcelas.get(52).getDataVencimento().compareTo(LocalDate.of(2021, Month.JUNE, 30)) , 0 );
		Assert.assertEquals("Parcela 54", listaParcelas.get(53).getDataVencimento().compareTo(LocalDate.of(2021, Month.JULY, 31)) , 0 );
		Assert.assertEquals("Parcela 55", listaParcelas.get(54).getDataVencimento().compareTo(LocalDate.of(2021, Month.AUGUST, 31)) , 0 );
		Assert.assertEquals("Parcela 56", listaParcelas.get(55).getDataVencimento().compareTo(LocalDate.of(2021, Month.SEPTEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 57", listaParcelas.get(56).getDataVencimento().compareTo(LocalDate.of(2021, Month.OCTOBER, 31)) , 0 );
		Assert.assertEquals("Parcela 58", listaParcelas.get(57).getDataVencimento().compareTo(LocalDate.of(2021, Month.NOVEMBER, 30)) , 0 );
		Assert.assertEquals("Parcela 59", listaParcelas.get(58).getDataVencimento().compareTo(LocalDate.of(2021, Month.DECEMBER, 31)) , 0 );
		Assert.assertEquals("Parcela 60", listaParcelas.get(59).getDataVencimento().compareTo(LocalDate.of(2022, Month.JANUARY, 31)) , 0 );


	}
	
	@Test
	public void testDataVencimento60XUltimodiaMesSegundaParcela() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.JANUARY, 31);
		int numParcela =60;
		CronogramaBO c = new CronogramaBO();
		List<Parcela> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);
		
		
		Assert.assertEquals(listaParcelas.get(1).getDataVencimento().compareTo(LocalDate.of(2017, Month.MARCH, 31)) , 0 );
		

	}
	
}
