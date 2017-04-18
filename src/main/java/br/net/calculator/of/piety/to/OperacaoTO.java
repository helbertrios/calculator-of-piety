package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumSistemaAmortizacao;

public class OperacaoTO {

	private BigDecimal valorOperacao;
	private BigDecimal cet;
	private LocalDate dataLiberacao;
	private BigDecimal taxa;
	private Integer quantidadeParcela;
	private List<ParcelaTO> parcelas;
	private EnumSistemaAmortizacao sistemaAmortizacao;

	public BigDecimal getCet() {
		return cet;
	}

	public void setCet(BigDecimal cet) {
		this.cet = cet;
	}

	public List<ParcelaTO> getParcelas() {
		if (parcelas == null) {
			parcelas = new ArrayList<ParcelaTO>();

		}

		return parcelas;
	}

	public void setParcelas(List<ParcelaTO> parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public LocalDate getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDate dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public EnumSistemaAmortizacao getSistemaAmortizacao() {
		return sistemaAmortizacao;
	}

	public void setSistemaAmortizacao(EnumSistemaAmortizacao sistemaAmortizacao) {
		this.sistemaAmortizacao = sistemaAmortizacao;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder(super.toString()+'\n');
		
		retorno.append("======================================================="+'\n'+'\n');
		retorno.append("valor Operacao...........: " + getValorOperacao()+'\n');
		retorno.append("Cet Operacao.............: " + getCet()+'\n');
		retorno.append("Data Liberacao...........: " + getDataLiberacao()+'\n');
		retorno.append("Taxa.....................: " + getTaxa().multiply(new BigDecimal("100"))+'\n');
		retorno.append("Qtd Parcelas.............: " + getQuantidadeParcela()+'\n');
		retorno.append("Sistema de Amortização...: " + getSistemaAmortizacao().getDescricao()+'\n');		
		
		for (ParcelaTO parcela : getParcelas()) {
			retorno.append("======================================================="+'\n');
			retorno.append(""+'\n');
			retorno.append("Vencimento.......: " + parcela.getDataVencimento()+'\n');
			retorno.append("Valor Parcela.......: " + parcela.getValor(null)+'\n');			
			for (DetalheParcelaTO detalheParcela : parcela.getDetalhesParcela()) {
				retorno.append("......=================================================="+'\n');
				retorno.append("......Tipo Detalhe ...........: " + detalheParcela.getTipoDetalheParcela().getDescricao()+'\n');
				retorno.append("......Valor ..................: " + detalheParcela.getValor()+'\n');
				retorno.append("......Descrição...............: " + detalheParcela.getDescricao()+'\n');
				if(detalheParcela.getDetalheParcelaAnterior() != null){ 
					retorno.append("..........Detalhe Anterior====================================="+'\n');
					retorno.append("..............Tipo Detalhe ...........: " + detalheParcela.getDetalheParcelaAnterior().getTipoDetalheParcela().getDescricao()+'\n');
					retorno.append("..............Valor ..................: " + detalheParcela.getDetalheParcelaAnterior().getValor()+'\n');
					retorno.append("..............Descrição...............: " + detalheParcela.getDetalheParcelaAnterior().getDescricao()+'\n');
					retorno.append("..............================================================="+'\n');
				}
				retorno.append("......================================================="+'\n');
			}
			retorno.append("Valor Parcela....: " + parcela.getValor(null)+'\n');
		}
		retorno.append(""+'\n');
		retorno.append("======================================================="+'\n');


		return retorno.toString() ;
	}

}
