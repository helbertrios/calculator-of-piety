package br.net.calculator.of.piety.to;

import java.util.List;

public interface ICalculoEncargos {
	

	public List<EncargoTO> getEncargosTO();
	public void setEncargosTO(List<EncargoTO> encargosTO) ;
	public List<DetalheParcelaTO> getDetalhesParcela() ;
	public void setDetalheParcela(List<DetalheParcelaTO> detalhesParcela) ;
	
	
	

}
