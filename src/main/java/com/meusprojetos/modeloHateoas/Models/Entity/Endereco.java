package com.meusprojetos.modeloHateoas.Models.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String numero;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private Boolean principal = false;
	@ManyToOne(fetch = FetchType.LAZY)
	private Pessoa pessoa;
}
