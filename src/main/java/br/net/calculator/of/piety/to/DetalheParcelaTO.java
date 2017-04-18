package br.net.calculator.of.piety.to;

import java.math.BigDecimal;

public class DetalheParcelaTO {
	
	private BigDecimal valor;
	private String descricao;
	private DetalheParcelaTO detalheParcelaAnterior;
	private TipoDetalheParcela tipoDetalheParcela;

	
	public DetalheParcelaTO(TipoDetalheParcela tipoDetalheParcela) {
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



	public TipoDetalheParcela getTipoDetalheParcela() {
		return tipoDetalheParcela;
	}

	public void setTipoDetalheParcela(TipoDetalheParcela tipoDetalheParcela) {
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
	
}
