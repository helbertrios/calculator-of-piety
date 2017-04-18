package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumMomentoCobrancaEncargo;
import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;
import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.EncargoTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.util.math.bigdecimal.util.OpcoesCalculo;

public abstract class Calculadora {

	final OperacaoTO operacaoTO;

	public static Calculadora getInstancia(final EnumSistemaAmortizacao sistemaAmortizacao,
			final LocalDate dataLiberacao, final Integer quantidadeParcela, final BigDecimal valorOperacao,
			final List<LocalDate> vencimentos, final BigDecimal taxa) {

		if (EnumSistemaAmortizacao.PRICE.equals(sistemaAmortizacao)) {
			return new CalculadoraPrice(dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
		}

		if (EnumSistemaAmortizacao.SAC.equals(sistemaAmortizacao)) {
			return new CalculadoraSac(dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
		}

		throw new UnsupportedOperationException("Sistema de amortiza��o n�o suportado");
	}

	public static Calculadora getInstancia(final EnumSistemaAmortizacao sistemaAmortizacao,
			final OperacaoTO operacaoTO) {

		if (EnumSistemaAmortizacao.PRICE.equals(sistemaAmortizacao)) {
			return new CalculadoraPrice(operacaoTO);
		}

		if (EnumSistemaAmortizacao.SAC.equals(sistemaAmortizacao)) {
			return new CalculadoraSac(operacaoTO);
		}

		throw new UnsupportedOperationException("Sistema de amortiza��o n�o suportado");
	}

	public Calculadora(final EnumSistemaAmortizacao sistemaAmortizacao, final LocalDate dataLiberacao,
			final Integer quantidadeParcela, final BigDecimal valorOperacao, final List<LocalDate> vencimentos,
			final BigDecimal taxa) {
		super();
		operacaoTO = new OperacaoTO();
		operacaoTO.setDataLiberacao(dataLiberacao);
		operacaoTO.setQuantidadeParcela(quantidadeParcela);
		operacaoTO.setValorOperacao(valorOperacao);
		operacaoTO.setTaxa(taxa);
		operacaoTO.setParcelas(new ArrayList<ParcelaTO>(quantidadeParcela));
		operacaoTO.setSistemaAmortizacao(sistemaAmortizacao);

		montarVencimentoDoCronogramaParcelas(operacaoTO.getParcelas(), vencimentos);

		//calcularCapitalDeTodasParcelas();
		// calcularJurosDeTodasParcelas();
		//calcularEncargos();
	}

	public Calculadora(final EnumSistemaAmortizacao sistemaAmortizacao, final OperacaoTO operacaoTO) {
		super();
		this.operacaoTO = operacaoTO;

		operacaoTO.setSistemaAmortizacao(sistemaAmortizacao);
		if (operacaoTO.getParcelas().size() != operacaoTO.getQuantidadeParcela()) {
			throw new IllegalArgumentException("As parcelas n�o foram geradas corretamente.");
		}

		//calcularCapitalDeTodasParcelas();
		//calcularEncargos();
	}

	public abstract BigDecimal getValorPrimeiraParcelaCapitalOperacao();

	public abstract void calcularCapitalDeTodasParcelas();

	/*
	 * void calcularJurosDeTodasParcelas() {
	 * 
	 * BigDecimal saldoDevedor = operacaoTO.getValorOperacao();
	 * 
	 * for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) { DetalheParcelaTO
	 * jurosTO = new DetalheParcelaTO(EnumTipoDetalheParcela.JUROS);
	 * jurosTO.setDescricao(EnumTipoDetalheParcela.JUROS.getDescricao());
	 * jurosTO.setValor(saldoDevedor.multiply(operacaoTO.getTaxa(),
	 * OpcoesCalculo.MathContextPadrao));
	 * parcelaTO.getDetalhesParcela().add(jurosTO);
	 * 
	 * saldoDevedor =
	 * saldoDevedor.subtract(parcelaTO.getValor(EnumTipoDetalheParcela.PRINCIPAL
	 * ), OpcoesCalculo.MathContextPadrao);
	 * 
	 * } }
	 */

	private void calcularEncargos(List<EncargoTO> encargosTO, ParcelaTO parcelaTO, BigDecimal saldoDevedor) {

		for (EncargoTO encargoTO : encargosTO) {
			EnumTipoDetalheParcela tipoDetalhe = EnumTipoDetalheParcela.OUTROS;
			if (encargoTO.getTipoDetalheParcela() != null){
				tipoDetalhe = encargoTO.getTipoDetalheParcela();
			}
			
			DetalheParcelaTO detalheParcelaTO = new DetalheParcelaTO(tipoDetalhe);
			detalheParcelaTO.setDescricao(encargoTO.getDescricaoEncargo());

			if (encargoTO.getTipoValorEncargo().equals(EnumTipoValorEncargo.VALOR)) {
				detalheParcelaTO.setValor(encargoTO.getValorEncargo());
			} else {

				detalheParcelaTO
						.setValor(saldoDevedor.multiply(encargoTO.getTaxaEncargo(), OpcoesCalculo.MathContextPadrao));
			}

			calcularEncargos(encargoTO.getEncargosTO(), parcelaTO, saldoDevedor.add(detalheParcelaTO.getValor()));

			if (encargoTO.getMomentoCobrancaEncargo().equals(EnumMomentoCobrancaEncargo.LIBERACAO)) {
				operacaoTO.getDespesasOperacao().getDetalhesParcela().add(detalheParcelaTO);
			} else {
				parcelaTO.getDetalhesParcela().add(detalheParcelaTO);
			}

		}
	}

	public void calcularEncargos() {
		BigDecimal saldoDevedor = operacaoTO.getValorOperacao();
		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {
			calcularEncargos(parcelaTO.getEncargosTO(), parcelaTO, saldoDevedor);

			saldoDevedor = saldoDevedor.subtract(parcelaTO.getValor(EnumTipoDetalheParcela.PRINCIPAL),
					OpcoesCalculo.MathContextPadrao);

		}
	}

	/**
	 * Monta os vencimentos no cronograma de opera��o de cr�dito.
	 * 
	 * @param cronograma
	 * @param vencimentos
	 * 
	 */
	private void montarVencimentoDoCronogramaParcelas(final List<ParcelaTO> cronograma,
			final List<LocalDate> vencimentos) {

		for (int i = 0; i < vencimentos.size(); i++) {
			ParcelaTO parcelaTO = new ParcelaTO();
			parcelaTO.setDataVencimento(vencimentos.get(i));
			cronograma.add(parcelaTO);
		}

	}

	public OperacaoTO getOperacaoTO() {
		return operacaoTO;
	}

}
