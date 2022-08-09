package com.meusprojetos.modeloHateoas.Models.Entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false) @Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> endereco;
}
