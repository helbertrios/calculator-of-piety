package br.net.calculator.of.piety.pietyEnums;

public enum EnumTipoLiberacao {
	LIQUIDO(1, "Liberação por Liquido"), BRUTO(2, "Bruto"), PARCELA(2, "Bruto");
	
	private Integer codigo;
	private String descricao;

	EnumTipoLiberacao(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumTipoLiberacao obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumTipoLiberacao o : values()){
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
