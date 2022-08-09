package com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos;

import java.util.Date;
import java.util.List;

import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoPessoaDto {

	private Long id;
	private String nome;
	private Date dataNascimento;
}
