package br.net.calculator.of.piety.to;

public enum SistemaAmortizacao {
	PRICE(1, "Price"), SAC(2, "SAC");
	
	private Integer codigo;
	private String descricao;

	SistemaAmortizacao(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static SistemaAmortizacao obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(SistemaAmortizacao o : values()){
			if(o.getCodigo().equals(codigo)){
				return o;
			}
		}
		
		return null;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}
