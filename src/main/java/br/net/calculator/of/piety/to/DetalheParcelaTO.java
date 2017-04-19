package br.net.calculator.of.piety.to;

import java.math.BigDecimal;

import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;

public class DetalheParcelaTO {

	private BigDecimal valor;
	private String descricao;
	private EnumTipoDetalheParcela tipoDetalheParcela;

	public DetalheParcelaTO(EnumTipoDetalheParcela tipoDetalheParcela) {
		super();
		this.tipoDetalheParcela = tipoDetalheParcela;

	}

	public DetalheParcelaTO(DetalheParcelaTO detalheParcelaAnterior) {
		super();
		this.tipoDetalheParcela = detalheParcelaAnterior.getTipoDetalheParcela();
	}

	public EnumTipoDetalheParcela getTipoDetalheParcela() {
		return tipoDetalheParcela;
	}

	public void setTipoDetalheParcela(EnumTipoDetalheParcela tipoDetalheParcela) {
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
		retorno.append("......==================================================" + '\n');
		return retorno.toString();
	}

}
