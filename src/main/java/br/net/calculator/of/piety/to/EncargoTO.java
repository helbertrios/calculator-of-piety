package br.net.calculator.of.piety.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.net.calculator.of.piety.pietyEnums.EnumMomentoCobrancaEncargo;
import br.net.calculator.of.piety.pietyEnums.EnumTipoDetalheParcela;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;

public class EncargoTO implements TO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5920597508486315031L;

	private BigDecimal valorEncargo; 
	private BigDecimal taxaEncargo;
	private String descricaoEncargo;
	private EnumTipoValorEncargo tipoValorEncargo;
	private EnumMomentoCobrancaEncargo momentoCobrancaEncargo;
	private EnumTipoDetalheParcela tipoDetalheParcela;
	private List<EncargoTO> encargosTO;
	
	
	

	
	public String getDescricaoEncargo() {
		return descricaoEncargo;
	}


	public void setDescricaoEncargo(String descricaoEncargo) {
		this.descricaoEncargo = descricaoEncargo;
	}


	public EnumTipoDetalheParcela getTipoDetalheParcela() {
		return tipoDetalheParcela;
	}


	public void setTipoDetalheParcela(EnumTipoDetalheParcela tipoDetalheParcela) {
		this.tipoDetalheParcela = tipoDetalheParcela;
	}


	public void addEncargo(EncargoTO encargoTO){
		getEncargosTO().add(encargoTO);
	}

	
	public EncargoTO() {
	}
	
	public EncargoTO(BigDecimal valor,  EnumTipoValorEncargo tipoEncargo, EnumMomentoCobrancaEncargo momentoCobrancaEncargo, EnumTipoDetalheParcela tipoDetalheParcela) {
		this.tipoDetalheParcela = tipoDetalheParcela;
		this.tipoValorEncargo = tipoEncargo;
		this.momentoCobrancaEncargo =  momentoCobrancaEncargo;
		
		if(this.tipoValorEncargo.equals(EnumTipoValorEncargo.PERCENTUAL)){
			this.taxaEncargo= valor;
		}else{
			this.valorEncargo= valor;
		}
	}
	
	public List<EncargoTO> getEncargosTO() {
		if (encargosTO == null) {
			encargosTO = new ArrayList<EncargoTO>(0);
			
		}

		return encargosTO;
	}
	
	
	public void setEncargosTO(List<EncargoTO> encargosTO) {
		this.encargosTO = encargosTO;
	}

	public BigDecimal getValorEncargo() {
		return valorEncargo;
	}
	public void setValorEncargo(BigDecimal valorEncargo) {
		this.valorEncargo = valorEncargo;
	}
	public BigDecimal getTaxaEncargo() {
		return taxaEncargo;
	}
	public void setTaxaEncargo(BigDecimal taxaEncargo) {
		this.taxaEncargo = taxaEncargo;
	}
	public EnumTipoValorEncargo getTipoValorEncargo() {
		return tipoValorEncargo;
	}
	public void setTipoValorEncargo(EnumTipoValorEncargo tipoValorEncargo) {
		this.tipoValorEncargo = tipoValorEncargo;
	}


	public EnumMomentoCobrancaEncargo getMomentoCobrancaEncargo() {
		return momentoCobrancaEncargo;
	}


	public void setMomentoCobrancaEncargo(EnumMomentoCobrancaEncargo momentoCobrancaEncargo) {
		this.momentoCobrancaEncargo = momentoCobrancaEncargo;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder(super.toString() + '\n');
		retorno.append("............=======================================================" + '\n');
		retorno.append("............Valor Encargo.......: " + getValorEncargo() + '\n');
		retorno.append("............Taxa Encargo........: " + getTaxaEncargo() + '\n');
		retorno.append("............Tipo Valor Encargo..: " + getTipoValorEncargo().getDescricao() + '\n');
		retorno.append("............Momento Encargo.....: " + getMomentoCobrancaEncargo().getDescricao() + '\n');	
		for (EncargoTO encargoTO : getEncargosTO()) {
			retorno.append("............Encargos do Encargo: " + encargoTO );
		}
		retorno.append("............=======================================================" + '\n');
		return retorno.toString();	}
	
	
	
	
	
	
}
