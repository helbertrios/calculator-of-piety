package br.net.calculator.of.piety.previa;

import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;

public class CronogramaBO {



	

/*
	public static void main(String[] args) {
		int numParcela = 60;
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 10);
		BigDecimal taxa = new BigDecimal("0.0172");
		BigDecimal valorOperacao = new BigDecimal("12000");

		CronogramaBO c = new CronogramaBO();
		List<ParcelaTO> listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);

		Operacao operacao = new Operacao();
		operacao.setDataLiberacao(dataLiberacao);
		operacao.setTaxa(taxa);
		operacao.setParcelas(listaParcelas);
		operacao.setValorOperacao(valorOperacao);

		c.calculaDetlheParcelaBaseadoPrice(operacao);
		printar(operacao);
		
		listaParcelas = c.obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(numParcela,
				dataLiberacao);

		operacao = new Operacao();
		operacao.setDataLiberacao(dataLiberacao);
		operacao.setTaxa(taxa);
		operacao.setParcelas(listaParcelas);
		operacao.setValorOperacao(valorOperacao);

		c.calculaDetlheParcelaBaseadoSAC(operacao);
		printar(operacao);
	}*/

	private static void printar(OperacaoTO operacao) {
		for (ParcelaTO parcela : operacao.getParcelas()) {
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
		System.out.println("");
		System.out.println("=======================================================");
		// System.out.println("Saldo Devedor Pricipal.:
		// "+operacao.getSaldoDevedorPrincipal());
		// System.out.println("Saldo Devedor Juros....:
		// "+operacao.getSaldoDevedorJuros(dataBase));
		// System.out.println("Saldo Devedor Devedor..:
		// "+operacao.getSaldoDevedor(dataBase));
		System.out.println("valor Operacao...........: " + operacao.getValorOperacao());
		System.out.println("=======================================================");

	}

}
