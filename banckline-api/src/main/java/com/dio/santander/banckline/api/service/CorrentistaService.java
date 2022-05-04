package com.dio.santander.banckline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banckline.api.dto.NovoCorrentistaDTO;
import com.dio.santander.banckline.api.model.Conta;
import com.dio.santander.banckline.api.model.Correntista;
import com.dio.santander.banckline.api.repositoy.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	CorrentistaRepository repository;
	
	public void save(NovoCorrentistaDTO form) {
		Correntista correntista = new Correntista();
		correntista.setNome(form.getNome());
		correntista.setCpf(form.getCpf());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		
		repository.save(correntista);
	}

}
