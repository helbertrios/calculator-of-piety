package br.net.calculator.of.piety.previa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parcela {

	private List<DetalheParcela> detalhesParcela;
	private LocalDate dataVencimento;

	public BigDecimal obterValorParcela() {
		BigDecimal saldoDevedor = new BigDecimal("0.00");
		for (DetalheParcela detalheParcela : detalhesParcela) {

			saldoDevedor = saldoDevedor.add(detalheParcela.getValor());
		}
		return saldoDevedor;

	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public List<DetalheParcela> getDetalhesParcela() {
		if (detalhesParcela == null) {
			detalhesParcela = new ArrayList<DetalheParcela>();

		}

		return detalhesParcela;
	}

	public void setDetalheParcela(List<DetalheParcela> detalhesParcela) {
		this.detalhesParcela = detalhesParcela;
	}

}
