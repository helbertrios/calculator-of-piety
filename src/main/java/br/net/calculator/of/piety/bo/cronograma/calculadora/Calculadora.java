package br.net.calculator.of.piety.bo.cronograma.calculadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.to.DetalheParcelaTO;
import br.net.calculator.of.piety.to.OperacaoTO;
import br.net.calculator.of.piety.to.ParcelaTO;
import br.net.calculator.of.piety.to.SistemaAmortizacao;
import br.net.calculator.of.piety.to.TipoDetalheParcela;
import br.net.calculator.of.piety.util.math.bigdecimal.util.OpcoesCalculo;

public abstract class Calculadora {

	final OperacaoTO operacaoTO;

	public static Calculadora getInstancia(final SistemaAmortizacao sistemaAmortizacao, final LocalDate dataLiberacao, final Integer quantidadeParcela, final BigDecimal valorOperacao, final List<LocalDate> vencimentos, final BigDecimal taxa) {		 					

		if (SistemaAmortizacao.PRICE.equals(sistemaAmortizacao)) {
			return new CalculadoraPrice(dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
		}

		if (SistemaAmortizacao.SAC.equals(sistemaAmortizacao)) {
			return new CalculadoraSac(dataLiberacao, quantidadeParcela, valorOperacao, vencimentos, taxa);
		}
		
		throw new UnsupportedOperationException("Sistema de amortização não suportado");
	}
	
	
	public static Calculadora getInstancia(final SistemaAmortizacao sistemaAmortizacao, final OperacaoTO operacaoTO) {

		if (SistemaAmortizacao.PRICE.equals(sistemaAmortizacao)) {
			return new CalculadoraPrice(operacaoTO);
		}

		if (SistemaAmortizacao.SAC.equals(sistemaAmortizacao)) {
			return new CalculadoraSac(operacaoTO);
		}
		
		throw new UnsupportedOperationException("Sistema de amortização não suportado");
	}

	public Calculadora(final SistemaAmortizacao sistemaAmortizacao, final LocalDate dataLiberacao, final Integer quantidadeParcela, final BigDecimal valorOperacao, final List<LocalDate> vencimentos, final BigDecimal taxa) {
		super();
		operacaoTO = new OperacaoTO();
		operacaoTO.setDataLiberacao(dataLiberacao);
		operacaoTO.setQuantidadeParcela(quantidadeParcela);
		operacaoTO.setValorOperacao(valorOperacao);
		operacaoTO.setTaxa(taxa);
		operacaoTO.setParcelas(new ArrayList<ParcelaTO>(quantidadeParcela));
		operacaoTO.setSistemaAmortizacao(sistemaAmortizacao);
		
		montarVencimentoDoCronogramaParcelas(operacaoTO.getParcelas(), vencimentos);
		
		calcularCapitalDeTodasParcelas();
		calcularJurosDeTodasParcelas();
	}

	public Calculadora(final SistemaAmortizacao sistemaAmortizacao, final OperacaoTO operacaoTO) {
		super();
		this.operacaoTO = operacaoTO;

		operacaoTO.setSistemaAmortizacao(sistemaAmortizacao);
		if (operacaoTO.getParcelas().size() != operacaoTO.getQuantidadeParcela()) {
			throw new IllegalArgumentException("As parcelas não foram geradas corretamente.");
		}
			
		
		calcularCapitalDeTodasParcelas();
		calcularJurosDeTodasParcelas();
	}

	public abstract BigDecimal getValorPrimeiraParcelaCapitalOperacao();

	abstract void calcularCapitalDeTodasParcelas();

	void calcularJurosDeTodasParcelas() {

		BigDecimal saldoDevedor = operacaoTO.getValorOperacao();

		for (ParcelaTO parcelaTO : operacaoTO.getParcelas()) {

			DetalheParcelaTO jurosTO = new DetalheParcelaTO(TipoDetalheParcela.JUROS);
			jurosTO.setDescricao(TipoDetalheParcela.JUROS.getDescricao());
			jurosTO.setValor(saldoDevedor.multiply(operacaoTO.getTaxa(), OpcoesCalculo.MathContextPadrao));
			parcelaTO.getDetalhesParcela().add(jurosTO);
			System.out.println(parcelaTO.getValor(TipoDetalheParcela.PRINCIPAL));

			saldoDevedor = saldoDevedor.subtract(parcelaTO.getValor(TipoDetalheParcela.PRINCIPAL), OpcoesCalculo.MathContextPadrao);

		}
	}

	
	/**
	 * Monta os vencimentos no cronograma de operação de crédito.
	 * 
	 * @param cronograma
	 * @param vencimentos
	 * 
	 */
	private void montarVencimentoDoCronogramaParcelas(final List<ParcelaTO> cronograma, final List<LocalDate> vencimentos) {

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
