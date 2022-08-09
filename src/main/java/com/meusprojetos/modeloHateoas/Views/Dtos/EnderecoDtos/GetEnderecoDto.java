package com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.GetPessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.InfoPessoaDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetEnderecoDto extends RepresentationModel<GetEnderecoDto>{

	private Long id;
	private String logradouro;
	private String numero;
	private String cidade;
	private String cep;
	private Boolean principal;
	@JsonIgnore
	private Long idPessoa;
}
