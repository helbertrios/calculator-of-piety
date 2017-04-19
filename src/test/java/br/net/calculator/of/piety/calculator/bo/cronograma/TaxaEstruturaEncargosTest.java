package br.net.calculator.of.piety.calculator.bo.cronograma;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.net.calculator.of.piety.bo.taxa.TaxaBO;
import br.net.calculator.of.piety.pietyEnums.EnumMomentoCobrancaEncargo;
import br.net.calculator.of.piety.pietyEnums.EnumTipoLancamento;
import br.net.calculator.of.piety.pietyEnums.EnumTipoValorEncargo;
import br.net.calculator.of.piety.to.EncargoTO;


public class TaxaEstruturaEncargosTest {

	@Test
	public void testComUmaTaxa() {
		
		TaxaBO taxaBO = new TaxaBO();
		BigDecimal taxa = new BigDecimal("0.0190");
		List<EncargoTO> encargosTO = new ArrayList<>();
		
		EncargoTO encargoTO = new EncargoTO();
		encargoTO.setTaxaEncargo(taxa);
		encargoTO.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargosTO.add(encargoTO);
		
		
		
		
		Assert.assertEquals(taxa.doubleValue(), taxaBO.obterTaxa(encargosTO, null).doubleValue(), 0.01);
		
	}
	
	

	@Test
	public void testComDuasTaxaMesmoNivel() {
		TaxaBO taxaBO = new TaxaBO();
		List<EncargoTO> encargosTO = new ArrayList<>();
		
		EncargoTO encargoTO = new EncargoTO();
		encargoTO.setTaxaEncargo(new BigDecimal("0.0190"));
		encargoTO.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargosTO.add(encargoTO);
		
		encargoTO = new EncargoTO();
		encargoTO.setTaxaEncargo(new BigDecimal("0.020"));
		encargoTO.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargosTO.add(encargoTO);
		
		
		
		
		Assert.assertEquals( 0.0390, taxaBO.obterTaxa(encargosTO, null).doubleValue(), 0.01);
		
	}

	@Test
	public void testComDuasTaxaNiveisDiferente() {
		TaxaBO taxaBO = new TaxaBO();
		List<EncargoTO> encargosTO = new ArrayList<>();
		List<EncargoTO> encargosTO11 = new ArrayList<>();
		
		EncargoTO encargoTO1 = new EncargoTO();
		EncargoTO encargoTO11 = new EncargoTO();
		
		encargoTO11.setTaxaEncargo(new BigDecimal("0.020"));
		encargoTO11.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargosTO11.add(encargoTO11);
		
		encargoTO1.setTaxaEncargo(new BigDecimal("0.0190"));
		encargoTO1.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargoTO1.setEncargosTO(encargosTO11);
		encargosTO.add(encargoTO1);
		
		
	
		
		Assert.assertEquals( 0.039380, taxaBO.obterTaxa(encargosTO, null).doubleValue(), 0.01);
		
	}
	
	@Test
	public void testComDuasTaxaEmCadaNivelENiveisDiferente() {
		TaxaBO taxaBO = new TaxaBO();
		List<EncargoTO> listaEncargosTO = new ArrayList<>();
		List<EncargoTO> listaEncargosTO1 = new ArrayList<>();
		List<EncargoTO> listaEncargosTO2 = new ArrayList<>();
		
		EncargoTO encargoTO1 = new EncargoTO();
		EncargoTO encargoTO2 = new EncargoTO();
		
		EncargoTO encargoTO11 = new EncargoTO();
		EncargoTO encargoTO12 = new EncargoTO();
		
		EncargoTO encargoTO21 = new EncargoTO();
		EncargoTO encargoTO22 = new EncargoTO();
		
		
		encargoTO11.setTaxaEncargo(new BigDecimal("0.020"));
		encargoTO11.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);

		encargoTO12.setTaxaEncargo(new BigDecimal("0.030"));
		encargoTO12.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		
		listaEncargosTO1.add(encargoTO11);
		listaEncargosTO1.add(encargoTO12);
		
		encargoTO1.setTaxaEncargo(new BigDecimal("0.0190"));
		encargoTO1.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargoTO1.setEncargosTO(listaEncargosTO1);
		


		encargoTO21.setTaxaEncargo(new BigDecimal("0.080"));
		encargoTO21.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);

		encargoTO22.setTaxaEncargo(new BigDecimal("0.070"));
		encargoTO22.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		
		listaEncargosTO2.add(encargoTO21);
		listaEncargosTO2.add(encargoTO22);
		
		encargoTO2.setTaxaEncargo(new BigDecimal("0.065"));
		encargoTO2.setTipoValorEncargo(EnumTipoValorEncargo.PERCENTUAL);
		encargoTO2.setEncargosTO(listaEncargosTO2);
		
		
		
		
		listaEncargosTO.add(encargoTO1);
		listaEncargosTO.add(encargoTO2);
		
		
	
		
		Assert.assertEquals( 0.29470, taxaBO.obterTaxa(listaEncargosTO, null).doubleValue(), 0.01);
		
	}
	

	@Test
	public void testComSeisTaxaMesmoNivel() {
		
		TaxaBO taxaBO = new TaxaBO();
		
		List<EncargoTO> listaEncargosTO = new ArrayList<>();
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0190") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0200") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0170") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0250") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0320") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		listaEncargosTO.add(new EncargoTO(new BigDecimal("0.0610") ,EnumTipoValorEncargo.PERCENTUAL, EnumMomentoCobrancaEncargo.PARCELA, EnumTipoLancamento.JUROS));
		
		Assert.assertEquals( 0.1740, taxaBO.obterTaxa(listaEncargosTO,  null).doubleValue(), 0.01);
		
	}
}

