package br.net.calculator.of.piety.previa;

public enum EnumTipoDetalhes {
	PRINCIPAL(1, "Principal"), JUROS(2, "Juros");
	
	private Integer codigo;
	private String descricao;

	EnumTipoDetalhes(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoDetalhes obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoDetalhes o : values()){
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
