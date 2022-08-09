package com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;

import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.InfoEnderecoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class GetPessoaDto extends RepresentationModel<GetPessoaDto>{

	private Long id;
	private String nome;
	private Date dataNascimento;
	private GetEnderecoDto enderecoPrincipal;
	
	
}
