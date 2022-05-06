package com.dio.santander.banckline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banckline.api.dto.NovaMovimentacaoDTO;
import com.dio.santander.banckline.api.model.Movimentacao;
import com.dio.santander.banckline.api.repositoy.MovimentacaoRepository;
import com.dio.santander.banckline.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacoesController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<NovaMovimentacaoDTO> findById(@PathVariable Long id) throws Exception{
		
	  NovaMovimentacaoDTO saved =	service.findById(id);
	  
	  return ResponseEntity.ok(saved);
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacaoDTO movimentacao) {
		service.save(movimentacao);
	}

}
