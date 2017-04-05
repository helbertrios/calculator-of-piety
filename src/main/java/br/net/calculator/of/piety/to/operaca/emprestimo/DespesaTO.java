package br.net.calculator.of.piety.to.operaca.emprestimo;

import java.math.BigDecimal;

import br.net.calculator.of.piety.to.TO;

public class DespesaTO implements TO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2807364128897612199L;
	private BigDecimal valorDespesa;
	private String nomeDespesa;
	private String id;
	private TaxaTO taxa;
	
	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	public String getNomeDespesa() {
		return nomeDespesa;
	}
	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TaxaTO getTaxa() {
		return taxa;
	}
	public void setTaxa(TaxaTO taxa) {
		this.taxa = taxa;
	}
	

	
	
}
