package br.net.calculator.of.piety.calculator.cet;

import java.math.BigDecimal;
import java.math.MathContext;

import br.net.calculator.of.piety.data.UtilData;
import br.net.calculator.of.piety.math.bigdecimal.util.BigFunctions;
import br.net.calculator.of.piety.to.cet.DadosEmprestimoCETTO;


public class CalculatorCET {

	
	private static final double CET_PRECISION = 0.00000001;
	private static final double DAY_OF_YEAR = 365;
	public static final int SCALE = 128;


    /**

     * @param cet CET anterior calculado 
     * @param dadosEmprestimoCET Dados Necessarios para calculo do CET 
     * @return Retorna o CET anual da Operação
     */
	private static BigDecimal fcetOperacao(BigDecimal cet, DadosEmprestimoCETTO dadosEmprestimoCET) {

		BigDecimal fCet = new BigDecimal(0.0d);
		int index = 0;
		while (index < dadosEmprestimoCET.getParcelasCet().size()) {

			Long diasEntreParcelasDoublePrimitive = UtilData.retornaDiferencaEmDiasEntreDatas(dadosEmprestimoCET.getDataLiberacao(), dadosEmprestimoCET.getParcelasCet().get(index)
					.getDataCobranca());
			

			BigDecimal diasEntreParcelas = new BigDecimal(diasEntreParcelasDoublePrimitive);
			BigDecimal diasAno = new BigDecimal(DAY_OF_YEAR);
			BigDecimal umMaisCet = new BigDecimal("0.00");
			BigDecimal resultadoDaExponenciacao = new BigDecimal("0.00");
			BigDecimal fcj_valorParcela = dadosEmprestimoCET.getParcelasCet().get(index).getValorParcela();

			umMaisCet = BigDecimal.ONE.add(cet, MathContext.DECIMAL128);

			resultadoDaExponenciacao = BigFunctions.exp(BigFunctions.ln(umMaisCet, SCALE)
					.multiply(diasEntreParcelas.divide(diasAno, MathContext.DECIMAL128)), SCALE);

			fCet = fCet.add(fcj_valorParcela.divide(resultadoDaExponenciacao, MathContext.DECIMAL128),
					MathContext.DECIMAL128);
			
			
		
			index = index + 1;

		}

		fCet = fCet.subtract(new BigDecimal(dadosEmprestimoCET.getValorDaOperacaoParaCET()));

		return fCet;
	}


	/**
	 * 
	 * @param dadosEmprestimoCET
	 * @return
	 */
	public static BigDecimal cetOperacao(DadosEmprestimoCETTO dadosEmprestimoCET) {

		BigDecimal intervalo = new BigDecimal("1.00");

		BigDecimal lower_cet = new BigDecimal("0.00");
		BigDecimal upper_cet = new BigDecimal("1.00");

		BigDecimal lower_fcet = new BigDecimal("0.00");
		BigDecimal upper_fcet = new BigDecimal("0.00");

		BigDecimal precisao = new BigDecimal(CET_PRECISION);


		lower_fcet = fcetOperacao(lower_cet, dadosEmprestimoCET);

		upper_fcet = fcetOperacao(upper_cet, dadosEmprestimoCET);


		while (lower_fcet.multiply(upper_fcet, MathContext.DECIMAL128).compareTo(BigDecimal.ZERO) == 1) {
			upper_cet = upper_cet.add(intervalo);
			upper_fcet = fcetOperacao(upper_cet, dadosEmprestimoCET);

		}

		while (upper_cet.subtract(lower_cet, MathContext.DECIMAL128).compareTo(precisao) == 1) {

			BigDecimal mean_cet = new BigDecimal("0.00");
			BigDecimal mean_fcet = new BigDecimal("0.00");

			mean_cet = lower_cet.add(upper_cet).divide(new BigDecimal("2.00"), MathContext.DECIMAL128);

			mean_fcet = fcetOperacao(mean_cet, dadosEmprestimoCET);

			BigDecimal mutiplicacaoMeanXLower = new BigDecimal("0.00");
			mutiplicacaoMeanXLower = mean_fcet.multiply(lower_fcet, MathContext.DECIMAL128);

			if (mutiplicacaoMeanXLower.compareTo(BigDecimal.ZERO) == 1) {
				lower_cet = mean_cet;
			} else {
				upper_cet = mean_cet;
			}

		}

		return lower_cet.multiply(new BigDecimal(100d, MathContext.DECIMAL128));
	}

}
