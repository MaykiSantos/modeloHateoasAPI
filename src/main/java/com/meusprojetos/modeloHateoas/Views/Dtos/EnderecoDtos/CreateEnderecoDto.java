package com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.RepresentationModel;

import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEnderecoDto {

	@NotEmpty
	private String logradouro;
	@NotEmpty
	private String numero;
	@NotEmpty
	private String cidade;
	@Pattern(regexp = "\\d{5}-\\d{3}")
	private String cep;
	@NotNull @Positive
	private Long pessoaId;
	private Boolean principal = false;
	
	public Endereco paraEndereco() {
		var e = new Endereco();
		e.setCep(cep);
		e.setCidade(cidade);
		e.setLogradouro(logradouro);
		e.setNumero(numero);
		e.setPrincipal(principal);
		return e;
	}
}
