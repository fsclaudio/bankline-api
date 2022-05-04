package com.dio.santander.banckline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banckline.api.dto.NovaMovimentacaoDTO;
import com.dio.santander.banckline.api.model.Correntista;
import com.dio.santander.banckline.api.model.Movimentacao;
import com.dio.santander.banckline.api.model.MovimentacaoTipo;
import com.dio.santander.banckline.api.repositoy.CorrentistaRepository;
import com.dio.santander.banckline.api.repositoy.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntista;
	
	public void save(NovaMovimentacaoDTO form) {
		Movimentacao movementacao = new Movimentacao();
		
		Double valor = form.getTipo()==MovimentacaoTipo.RECEITA ? form.getValor() : form.getValor() * -1;
				
		movementacao.setDataHora(LocalDateTime.now());
		movementacao.setDescricao(form.getDescricao());
		movementacao.setIdConta(form.getIdConta());
		movementacao.setTipo(form.getTipo());
		movementacao.setValor(valor);
		
		Correntista corrent = correntista.findById(form.getIdConta()).orElse(null);
		if(corrent != null) {
			corrent.getConta().setSaldo(corrent.getConta().getSaldo()+ valor);
			correntista.save(corrent);
		}
		repository.save(movementacao);
	}

}
