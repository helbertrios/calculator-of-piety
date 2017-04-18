package br.net.calculator.of.piety.bo.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalcularDataVencimentoBO {
	
	
	/**
	 * Calcula do cronograma de vencimento mensal com inicio no m�s seguinte a libera��o da opera��o de cr�dito.
	 * 
	 * @param quantidadeParcelas 
	 * @param dataLiberacao
	 * 
	 * @return Data de vencimento das parcelas da opera��o de cr�dito
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
