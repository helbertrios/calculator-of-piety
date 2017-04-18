package br.net.calculator.of.piety.pietyEnums;

public enum EnumTipoIndexacao {
	POS_FIXADO(1, "Pós Fixado"), PRE_FIXADO(2, "Pré Fixado");
	
	private Integer codigo;
	private String descricao;

	EnumTipoIndexacao(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoIndexacao obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoIndexacao o : values()){
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
