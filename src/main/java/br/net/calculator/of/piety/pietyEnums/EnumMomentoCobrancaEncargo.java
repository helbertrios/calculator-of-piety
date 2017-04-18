package br.net.calculator.of.piety.pietyEnums;

public enum EnumMomentoCobrancaEncargo {
	LIBERACAO(1, "Liberação"), PARCELA(2, "Parcela");
	
	private Integer codigo;
	private String descricao;

	EnumMomentoCobrancaEncargo(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static EnumMomentoCobrancaEncargo obterPorCodigo(Integer codigo){
		if(codigo == null){
			return null;
		}
		
		for(EnumMomentoCobrancaEncargo o : values()){
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
