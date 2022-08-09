package com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.meusprojetos.modeloHateoas.Models.Entity.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class CreatePessoaDto {

	@NotEmpty
	private String nome;
	@Past @NotNull
	private Date dataNascimento;
	
	public Pessoa paraPessoa() {
		var p = new Pessoa();
		p.setDataNascimento(dataNascimento);
		p.setNome(nome);
		return p;
	}
}
