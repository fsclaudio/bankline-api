package com.dio.santander.banckline.api.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banckline.api.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {

}
