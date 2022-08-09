package com.meusprojetos.modeloHateoas.Assemblers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.meusprojetos.modeloHateoas.Models.Entity.Pessoa;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.GetPessoaDto;

@Component
public class PessoaRepresentationAssembler implements RepresentationModelAssembler<Pessoa, GetPessoaDto> {
	
	@Autowired
	private EnderecoRepresentationAssembler enderecoRepresentationAssembler;
	
	@Override
	public GetPessoaDto toModel(Pessoa entity) {
		return paraGetPessoaDto(entity);
	}
	
	private GetPessoaDto paraGetPessoaDto(Pessoa pessoa) {
		var gP = new GetPessoaDto();
		gP.setId(pessoa.getId());
		gP.setNome(pessoa.getNome());
		gP.setDataNascimento(pessoa.getDataNascimento());
		
		if(pessoa.getEndereco() != null) {
			var enderecoPrincipal = pessoa.getEndereco().stream().filter(e -> e.getPrincipal() == true).findAny().orElse(null);
			if(enderecoPrincipal != null) {
				gP.setEnderecoPrincipal(enderecoRepresentationAssembler.toModel(enderecoPrincipal));			
			}			
		}
		
		
//		gP.setEndereco(CollectionModel.of(pessoa.getEndereco().stream()
//				.map((e) -> enderecoRepresentationAssembler.toModel(e)).collect(Collectors.toList())));
		
		return gP;
	}

}
