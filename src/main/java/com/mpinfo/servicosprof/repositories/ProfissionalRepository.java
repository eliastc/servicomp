package com.mpinfo.servicosprof.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mpinfo.servicosprof.domain.Profissao;
import com.mpinfo.servicosprof.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Profissional obj INNER JOIN obj.profissoes prof WHERE obj.nome LIKE %:nome% AND prof IN :profissoes")
	Page<Profissional> search(@Param("nome") String nome,@Param("profissoes") List<Profissao> profissoes, Pageable pageRequest);
}
