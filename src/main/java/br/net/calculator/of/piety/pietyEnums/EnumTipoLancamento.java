package br.net.calculator.of.piety.pietyEnums;


public enum EnumTipoLancamento {
	PRINCIPAL(1, "Principal"), JUROS(2, "Juros"), INDEXADOR(3, "Indexador"), OUTROS(3, "Outros");
	
	private Integer codigo;
	private String descricao;

	EnumTipoLancamento(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoLancamento obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoLancamento o : values()){
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
