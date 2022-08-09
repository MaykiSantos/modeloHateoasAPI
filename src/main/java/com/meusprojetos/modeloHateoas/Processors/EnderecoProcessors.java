package com.meusprojetos.modeloHateoas.Processors;

import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.meusprojetos.modeloHateoas.Controller.EnderecoController;
import com.meusprojetos.modeloHateoas.Controller.PessoaController;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;

@Component
public class EnderecoProcessors implements RepresentationModelProcessor<GetEnderecoDto> {

	@Override
	public GetEnderecoDto process(GetEnderecoDto model) {
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoController.class)
				.buscar(model.getId())).withSelfRel());
		model.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class)
						.buscar(model.getIdPessoa())).withRel("pessoa"));

		if (!model.getPrincipal()) {
			model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoController.class)
							.definirComoPrincipal(model.getId())).withRel("definirComoPrincipal"));
		}

		return model;
	}

}
