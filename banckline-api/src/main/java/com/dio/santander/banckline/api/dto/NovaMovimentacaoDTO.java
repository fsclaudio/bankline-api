package com.dio.santander.banckline.api.dto;

import com.dio.santander.banckline.api.model.MovimentacaoTipo;

public class NovaMovimentacaoDTO {
	
	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Long idConta;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public MovimentacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	
	

}
