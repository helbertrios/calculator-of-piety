package br.net.calculator.of.piety.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.calculator.cet.CalculatorCET;
import br.net.calculator.of.piety.to.cet.DadosEmprestimoCETTO;
import br.net.calculator.of.piety.to.cet.ParcelaCETTO;
import br.net.calculator.of.piety.to.operaca.emprestimo.CalendarioParcelaTO;
import br.net.calculator.of.piety.to.operaca.emprestimo.DadosOperacaoTO;
import br.net.calculator.of.piety.to.operaca.emprestimo.ParcelaOperacaoTO;
import br.net.calculator.of.piety.to.operaca.emprestimo.TaxaTO;

public class CalculaOperacaoEmprestimo {

	public void calcularEmprestimo() {

		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 05);
		Integer numeroParcela = 24;
		double valorBruto = 10000.00;
		
		TaxaTO taxaFixa = getTaxa();

		DadosOperacaoTO dadosOperacao = new DadosOperacaoTO();
		
		dadosOperacao.setDataLiberacao(dataLiberacao);
		dadosOperacao.setTaxaFixa(taxaFixa);
		dadosOperacao.setValorBruto(valorBruto);
		
		dadosOperacao.setParcelasOperacao(gerarParcelaOperacao(numeroParcela));
		
		calculaOperacoesAnteriores(dadosOperacao);
		
		calculaValorParcelasPrice(dadosOperacao);
		
		calculaValorLiquido(dadosOperacao);

		BigDecimal cet = apuraCet(dadosOperacao.getValorLiquido(), dadosOperacao.getDataLiberacao(),
				dadosOperacao.getParcelasOperacao());
		
		dadosOperacao.setCetOperacao(cet);
		
		System.out.println(dadosOperacao.toString());

	}

	private void calculaValorLiquido(DadosOperacaoTO dadosOperacao) {
		dadosOperacao.setValorLiquido(dadosOperacao.getValorBruto() -dadosOperacao.getValorOperacoesLiquidadas() );
		
	}

	private void calculaOperacoesAnteriores(DadosOperacaoTO dadosOperacao) {
		dadosOperacao.setValorOperacoesLiquidadas(0);
		
	}

	private BigDecimal apuraCet(Double valorParaCet, LocalDate dataLiberacao,
			List<ParcelaOperacaoTO> parcelasOperacao) {

		List<ParcelaCETTO> parcelaCETs = parcelaOperacaoToParcelaCET(parcelasOperacao);

		DadosEmprestimoCETTO dadosEmprestimoCET = new DadosEmprestimoCETTO();
		dadosEmprestimoCET.setDataLiberacao(dataLiberacao);
		dadosEmprestimoCET.setParcelasCet(parcelaCETs);
		dadosEmprestimoCET.setValorDaOperacaoParaCET(valorParaCet);

		return CalculatorCET.cetOperacao(dadosEmprestimoCET);
	}

	private List<ParcelaCETTO> parcelaOperacaoToParcelaCET(List<ParcelaOperacaoTO> parcelasOperacao) {
		List<ParcelaCETTO> parcelaCETs = new ArrayList<ParcelaCETTO>();

		for (ParcelaOperacaoTO parcelaOperacao : parcelasOperacao) {
			ParcelaCETTO parcelaCET = new ParcelaCETTO();
			parcelaCET.setDataCobranca(parcelaOperacao.getDataCobranca());
			parcelaCET.setValorParcela(parcelaOperacao.getValorParcela());
			parcelaCETs.add(parcelaCET);
		}
		return parcelaCETs;
	}

	public static void main(String[] args) {
		CalculaOperacaoEmprestimo v = new CalculaOperacaoEmprestimo();
		v.calcularEmprestimo();
	}

	private void calculaValorParcelasPrice(DadosOperacaoTO dadosOperacao) {

		setCalendarioParcelasPrice(dadosOperacao.getDataLiberacao().plusMonths(1), dadosOperacao.getParcelasOperacao());

		Integer qtdParcelas = dadosOperacao.getParcelasOperacao().size();
		BigDecimal valorParcela = new BigDecimal("0.00");
		BigDecimal valorOperacao = new BigDecimal(dadosOperacao.getValorBruto());

		if (dadosOperacao.getTaxaFixa().getPecentualTaxa().compareTo(BigDecimal.ZERO) == 0) {
			valorParcela = valorOperacao.divide(BigDecimal.valueOf(qtdParcelas), MathContext.DECIMAL128);
		} else {

			final BigDecimal i = dadosOperacao.getTaxaFixa().getPecentualTaxa();
			final BigDecimal umMaisI = BigDecimal.ONE.add(i);
			final BigDecimal umMaisIElevadoAN = umMaisI.pow(qtdParcelas);
			final BigDecimal iVezesUmMaisIElevadoAN = i.multiply(umMaisIElevadoAN);
			final BigDecimal umMaisIElevadoANMenosUm = umMaisIElevadoAN.subtract(BigDecimal.ONE);
			final BigDecimal valorPresenteDivididoPorUmMaisI = valorOperacao.divide(umMaisI, MathContext.DECIMAL128);
			final BigDecimal iVezesUmMaisIElevadoANVezesValorPresenteDivididoPorUmMaisI = iVezesUmMaisIElevadoAN
					.multiply(valorPresenteDivididoPorUmMaisI);
			
			valorParcela = iVezesUmMaisIElevadoANVezesValorPresenteDivididoPorUmMaisI.divide(umMaisIElevadoANMenosUm,
					MathContext.DECIMAL128);
		}

		for (ParcelaOperacaoTO parcelaOperacao : dadosOperacao.getParcelasOperacao()) {
			parcelaOperacao.setValorParcela(valorParcela);
		}

	}

	private List<ParcelaOperacaoTO> gerarParcelaOperacao(Integer numeroParcelas) {

		List<ParcelaOperacaoTO> parcelaOperacaos = new ArrayList<ParcelaOperacaoTO>();
		Integer contador = 1;
		while (contador <= numeroParcelas) {
			parcelaOperacaos.add(new ParcelaOperacaoTO());
			contador = contador + 1;
		}
		return parcelaOperacaos;

	}

	private void setCalendarioParcelasPrice(LocalDate dataPrimeiraParcela,
			List<? extends CalendarioParcelaTO> calendarioParcelas) {

		Integer contador = 1;

		for (CalendarioParcelaTO calendarioParcela : calendarioParcelas) {

			calendarioParcela.setDataCobranca(dataPrimeiraParcela.plusMonths(contador));

			contador = contador + 1;
		}

	}

	private TaxaTO getTaxa() {
		TaxaTO taxaFixa = new TaxaTO();
		taxaFixa.setPecentualTaxa(new BigDecimal(0.0200));
		return taxaFixa;
	}

}
