package br.net.calculator.of.piety.to;

public enum TipoDetalheParcela {
	PRINCIPAL(1, "Principal"), JUROS(2, "Juros");
	
	private Integer codigo;
	private String descricao;

	TipoDetalheParcela(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static TipoDetalheParcela obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(TipoDetalheParcela o : values()){
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
