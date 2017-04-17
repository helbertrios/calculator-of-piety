package br.net.calculator.of.piety.previa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CronogramaBO {

	public List<Parcela> obterCronogramaPagamentoMensalInicioMesSeguinteLiberacao(int numParcela,
			LocalDate dataLiberacao) {
		List<Parcela> listaParcelas = new ArrayList<Parcela>();

		for (int i = 1; i <= numParcela; i++) {
			Parcela p = new Parcela();
			LocalDate dataVencimento = dataLiberacao.plusMonths(i);
			p.setDataVencimento(dataVencimento);
			listaParcelas.add(p);
		}
		return listaParcelas;
	}

	public void calculaDetlheParcelaBaseadoPrice(Operacao operacao) {

		BigDecimal saldoDevedor = operacao.getValorOperacao();
		BigDecimal umMaisTaxa = BigDecimal.ONE.add(operacao.getTaxa());
		Integer prazo = operacao.getParcelas().size();
		BigDecimal dividendo = umMaisTaxa.pow(prazo).multiply(operacao.getTaxa());
		BigDecimal divisor = umMaisTaxa.pow(prazo).subtract(BigDecimal.ONE);
		float fator = dividendo.floatValue() / divisor.floatValue();
		BigDecimal valorParcela = new BigDecimal(saldoDevedor.floatValue() * fator);

		for (Parcela parcela : operacao.getParcelas()) {
			DetalheParcela d = new DetalheParcela();

			d.setValor(valorParcela.subtract(saldoDevedor.multiply(operacao.getTaxa(), MathContext.DECIMAL128),
					MathContext.DECIMAL128));
			d.setDescricao(EnumTipoDetalhes.PRINCIPAL.getDescricao());
			parcela.getDetalhesParcela().add(d);

			d = new DetalheParcela();
			d.setDescricao(EnumTipoDetalhes.JUROS.getDescricao());
			d.setValor(saldoDevedor.multiply(operacao.getTaxa(), MathContext.DECIMAL128));
			parcela.getDetalhesParcela().add(d);

			saldoDevedor = saldoDevedor.subtract(d.getValor(), MathContext.DECIMAL128);

		}

	}

	public void calculaDetlheParcelaBaseadoSAC(Operacao operacao) {

		BigDecimal saldoDevedor = operacao.getValorOperacao();
		int prazo = operacao.getParcelas().size();

		BigDecimal valorParcela = saldoDevedor.divide(new BigDecimal(prazo), MathContext.DECIMAL128);

		for (Parcela parcela : operacao.getParcelas()) {
			DetalheParcela d = new DetalheParcela();

			d.setValor(valorParcela);
			d.setDescricao(EnumTipoDetalhes.PRINCIPAL.getDescricao());
			parcela.getDetalhesParcela().add(d);

			d = new DetalheParcela();
			d.setDescricao(EnumTipoDetalhes.JUROS.getDescricao());
			d.setValor(saldoDevedor.multiply(operacao.getTaxa(), MathContext.DECIMAL128));
			parcela.getDetalhesParcela().add(d);

			saldoDevedor = saldoDevedor.subtract(d.getValor(), MathContext.DECIMAL128);

		}

	}

	public static void main(String[] args) {
		int numParcela = 60;
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
	}

	private static void printar(Operacao operacao) {
		for (Parcela parcela : operacao.getParcelas()) {
			System.out.println("=======================================================");
			System.out.println("");
			System.out.println("Vencimento.......: " + parcela.getDataVencimento());
			for (DetalheParcela detalheParcela : parcela.getDetalhesParcela()) {
				System.out.println("......==================================================");
				System.out.println("......Valor ..................: " + detalheParcela.getValor());
				System.out.println("......Tipo. ..................: " + detalheParcela.getDescricao());
				System.out.println("......=================================================");
			}
			System.out.println("Valor Parcela....: " + parcela.obterValorParcela());
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
