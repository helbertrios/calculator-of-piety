package br.net.calculator.of.piety.calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.calculator.cet.CalculatorCET;
import br.net.calculator.of.piety.to.cet.DadosEmprestimoCET;
import br.net.calculator.of.piety.to.cet.ParcelaCET;
import br.net.calculator.of.piety.to.operaca.emprestimo.CalendarioParcela;
import br.net.calculator.of.piety.to.operaca.emprestimo.DadosOperacao;
import br.net.calculator.of.piety.to.operaca.emprestimo.ParcelaOperacao;
import br.net.calculator.of.piety.to.operaca.emprestimo.Taxa;

public class CalculaOperacaoEmprestimo {
	
	public void calcularEmprestimo(){
		

		
		LocalDate dataLiberacao = LocalDate.of(2017, Month.APRIL, 05);
		Taxa taxaFixa = getTaxa();

		DadosOperacao dadosOperacao = new DadosOperacao();
		dadosOperacao.setDataLiberacao(dataLiberacao);
		dadosOperacao.setTaxaFixa(taxaFixa);
		dadosOperacao.setValorBruto(10000.00);
		
		dadosOperacao.setNumeroParcelas(24);
		
		dadosOperacao.setParcelasOperacao( getParcelaOperacao(dadosOperacao.getNumeroParcelas()));
		
		calculaValorParcelasPrice(dadosOperacao);
		
		List<ParcelaCET> parcelaCETs = parcelaOperacaoToParcelaCET(dadosOperacao);
		
		DadosEmprestimoCET dadosEmprestimoCET =  new DadosEmprestimoCET();
		dadosEmprestimoCET.setDataLiberacao(dadosOperacao.getDataLiberacao());
		dadosEmprestimoCET.setParcelasCet(parcelaCETs);
		dadosEmprestimoCET.setValorDaOperacaoParaCET(dadosOperacao.getValorLiquido());
		
		BigDecimal cet =  CalculatorCET.cetOperacao(dadosEmprestimoCET);
		
		System.out.println(dadosOperacao.toString());
		
	}



	private List<ParcelaCET> parcelaOperacaoToParcelaCET(DadosOperacao dadosOperacao) {
		List<ParcelaCET> parcelaCETs = new ArrayList<ParcelaCET>();
		
		for (ParcelaOperacao parcelaOperacao : dadosOperacao.getParcelasOperacao()) {
			ParcelaCET parcelaCET =  new ParcelaCET();
			parcelaCET.setDataCobranca(parcelaOperacao.getDataCobranca());
			parcelaCET.setValorParcela(parcelaOperacao.getValorParcela());
		}
		return parcelaCETs;
	}
	


	public static void main(String[] args) {
		CalculaOperacaoEmprestimo v = new CalculaOperacaoEmprestimo();
		v.calcularEmprestimo();
	}
	
	private void calculaValorParcelasPrice(DadosOperacao dadosOperacao){
		
		setCalendarioParcelasPrice(dadosOperacao.getDataLiberacao().plusMonths(1), dadosOperacao.getParcelasOperacao());
		BigDecimal valorParcela = new BigDecimal("250.00");
		
		for (ParcelaOperacao parcelaOperacao : dadosOperacao.getParcelasOperacao()) {
			parcelaOperacao.setValorParcela(valorParcela);
		}
		
	}

	private List<ParcelaOperacao> getParcelaOperacao(Integer numeroParcelas){
		
		List<ParcelaOperacao> parcelaOperacaos =  new ArrayList<ParcelaOperacao>();
		Integer contador = 1 ;
		while (contador <=  numeroParcelas) {
			parcelaOperacaos.add(new ParcelaOperacao());
			contador = contador + 1;	
		}
		return parcelaOperacaos;
	
	}

	
	private void setCalendarioParcelasPrice(LocalDate dataPrimeiraParcela, List<? extends CalendarioParcela> calendarioParcelas ){
		
		Integer contador = 1;
		
		for (CalendarioParcela calendarioParcela : calendarioParcelas) {
			
			calendarioParcela.setDataCobranca(dataPrimeiraParcela.plusMonths(contador));

			contador = contador + 1;		
		}
		
		
	
	}
	
	private Taxa getTaxa() {
		Taxa taxaFixa = new Taxa();
		taxaFixa.setPecentualTaxa(new BigDecimal(0.0200));
		return taxaFixa;
	}

}
