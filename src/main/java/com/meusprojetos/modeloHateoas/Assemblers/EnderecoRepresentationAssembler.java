package com.meusprojetos.modeloHateoas.Assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;

@Component
public class EnderecoRepresentationAssembler implements RepresentationModelAssembler<Endereco, GetEnderecoDto>{
	
	@Override
	public GetEnderecoDto toModel(Endereco entity) {
		return paraGetEnderecoDto(entity);
	}
	
	private GetEnderecoDto paraGetEnderecoDto(Endereco endereco) {
		var e = new GetEnderecoDto();
		e.setCep(endereco.getCep());
		e.setCidade(endereco.getCidade());
		e.setId(endereco.getId());
		e.setLogradouro(endereco.getLogradouro());
		e.setNumero(endereco.getNumero());
		e.setPrincipal(endereco.getPrincipal());
		e.setIdPessoa(endereco.getPessoa().getId());
		return e;
	}

}
