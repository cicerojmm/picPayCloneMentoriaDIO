package br.com.dio.picpayclone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.picpayclone.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	Page<Transacao> findByLogin(String login, Pageable paginacao);

	
}
