package br.net.calculator.of.piety.pietyEnums;

public enum EnumTipoCorrecao {
	SIMPLES(1, "Simples"), COMPOSTO(2, "Composto");
	
	private Integer codigo;
	private String descricao;

	EnumTipoCorrecao(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoCorrecao obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoCorrecao o : values()){
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
