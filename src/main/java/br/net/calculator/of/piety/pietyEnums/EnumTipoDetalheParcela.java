package br.net.calculator.of.piety.pietyEnums;

public enum EnumTipoDetalheParcela {
	PRINCIPAL(1, "Principal"), JUROS(2, "Juros"), OUTROS(3, "Outros");
	
	private Integer codigo;
	private String descricao;

	EnumTipoDetalheParcela(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoDetalheParcela obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoDetalheParcela o : values()){
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