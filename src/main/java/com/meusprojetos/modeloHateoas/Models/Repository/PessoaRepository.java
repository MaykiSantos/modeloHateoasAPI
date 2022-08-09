package com.meusprojetos.modeloHateoas.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meusprojetos.modeloHateoas.Models.Entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
