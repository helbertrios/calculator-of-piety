package br.net.calculator.of.piety;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.net.calculator.of.piety.calculator.bo.cronograma.CronogramaOperacaoCreditoBOTest;
import br.net.calculator.of.piety.calculator.bo.cronograma.TaxaEstruturaEncargosTest;
import br.net.calculator.of.piety.calculator.bo.data.CalcularDataVencimentoBOTest;

@RunWith(Suite.class)
@SuiteClasses({ CronogramaOperacaoCreditoBOTest.class, //test case 1
	            TaxaEstruturaEncargosTest.class,
	            CalcularDataVencimentoBOTest.class})
public class AllTests {

}
