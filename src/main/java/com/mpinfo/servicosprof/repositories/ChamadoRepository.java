package com.mpinfo.servicosprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpinfo.servicosprof.domain.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
