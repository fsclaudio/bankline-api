package com.dio.santander.banckline.api.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banckline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
