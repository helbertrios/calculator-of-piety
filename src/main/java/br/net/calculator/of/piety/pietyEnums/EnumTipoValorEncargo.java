package br.net.calculator.of.piety.pietyEnums;

public enum EnumTipoValorEncargo {
	
	VALOR(1, "Valor Fixo"), PERCENTUAL(2, "Percentual");
	
	private Integer codigo;
	private String descricao;

	EnumTipoValorEncargo(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoValorEncargo obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoValorEncargo o : values()){
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
