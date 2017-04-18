package br.net.calculator.of.piety.bo.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalcularDataVencimentoBO {
	
	
	/**
	 * Calcula do cronograma de vencimento mensal com inicio no mês seguinte a liberação da operação de crédito.
	 * 
	 * @param quantidadeParcelas 
	 * @param dataLiberacao
	 * 
	 * @return Data de vencimento das parcelas da operação de crédito
	 */

	public List<LocalDate> obterCronogramaVencimentoMensalComInicioNoMesSeguinteALiberacao(int quantidadeParcelas, LocalDate dataLiberacao) {
		
		List<LocalDate> listaVencimento = new ArrayList<LocalDate>(quantidadeParcelas);

		for (int i = 1; i <= quantidadeParcelas; i++) {	
			LocalDate dataVencimento = dataLiberacao.plusMonths(i);
			listaVencimento.add(dataVencimento);
		}
		
		return listaVencimento;
	}


}
