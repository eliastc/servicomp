package com.mpinfo.servicosprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpinfo.servicosprof.domain.ItemChamado;

@Repository
public interface ItemChamadoRepository extends JpaRepository<ItemChamado, Long> {

}
