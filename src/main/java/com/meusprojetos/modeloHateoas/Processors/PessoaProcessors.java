package com.meusprojetos.modeloHateoas.Processors;

import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.meusprojetos.modeloHateoas.Controller.PessoaController;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.GetPessoaDto;

@Component
public class PessoaProcessors implements RepresentationModelProcessor<GetPessoaDto> {

	@Override
	public GetPessoaDto process(GetPessoaDto model) {
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class)
				.buscar(model.getId())).withSelfRel());
		
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class)
				.enderecosDaPessoa(null, model.getId())).withRel("enderecos"));
		
		return model;
	}

}
