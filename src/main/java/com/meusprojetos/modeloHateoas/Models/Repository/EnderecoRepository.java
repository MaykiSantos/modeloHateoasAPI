package com.meusprojetos.modeloHateoas.Models.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


	Optional<List<Endereco>> findByPrincipalAndPessoaId(boolean b, Long id);

	Page<Endereco> findAllByPessoaId(Pageable pageable, Long idPessoa);

}
