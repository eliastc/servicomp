package com.mpinfo.servicosprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpinfo.servicosprof.domain.Profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

}
