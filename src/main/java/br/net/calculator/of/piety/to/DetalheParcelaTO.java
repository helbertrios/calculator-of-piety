package br.net.calculator.of.piety.to;

import java.math.BigDecimal;

import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;

public class DetalheParcelaTO {

	private BigDecimal valor;
	private String descricao;
	private DetalheParcelaTO detalheParcelaAnterior;
	private EnumTipoLancamento tipoDetalheParcela;

	public DetalheParcelaTO(EnumTipoLancamento tipoDetalheParcela) {
		super();
		this.detalheParcelaAnterior = null;
		this.tipoDetalheParcela = tipoDetalheParcela;

	}

	public DetalheParcelaTO(DetalheParcelaTO detalheParcelaAnterior) {
		super();
		this.detalheParcelaAnterior = detalheParcelaAnterior;
		this.tipoDetalheParcela = detalheParcelaAnterior.getTipoDetalheParcela();
	}

	public DetalheParcelaTO getDetalheParcelaAnterior() {
		return detalheParcelaAnterior;
	}

	public EnumTipoLancamento getTipoDetalheParcela() {
		return tipoDetalheParcela;
	}

	public void setTipoDetalheParcela(EnumTipoLancamento tipoDetalheParcela) {
		this.tipoDetalheParcela = tipoDetalheParcela;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;

	}

	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder(super.toString() + '\n');
		retorno.append("......==================================================" + '\n');
		retorno.append("......Tipo Detalhe ...........: " + getTipoDetalheParcela().getDescricao() + '\n');
		retorno.append("......Valor ..................: " + getValor() + '\n');
		retorno.append("......Descrição...............: " + getDescricao() + '\n');
		if (getDetalheParcelaAnterior() != null) {
			retorno.append("......Detalhe Anterior...............: " + getDetalheParcelaAnterior());
		}
		retorno.append("......==================================================" + '\n');
		return retorno.toString();
	}

}
