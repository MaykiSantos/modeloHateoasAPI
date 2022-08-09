package com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoEnderecoDto {

	private Long id;
	private String logradouro;
	private String numero;
	private String cidade;
	private String cep;
	private Boolean principal;
}
