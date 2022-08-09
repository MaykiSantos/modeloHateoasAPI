package com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class UpdateEnderecoDto {

	@NotEmpty
	private String logradouro;
	@NotEmpty
	private String numero;
	@NotEmpty
	private String cidade;
	@NotEmpty @Pattern(regexp = "\\d{5}-\\d{3}")
	private String cep;
	
	public Endereco paraEndereco() {
		var e = new Endereco();
		e.setCep(cep);
		e.setCidade(cidade);
		e.setLogradouro(logradouro);
		e.setNumero(numero);
		return e;
	}
}
