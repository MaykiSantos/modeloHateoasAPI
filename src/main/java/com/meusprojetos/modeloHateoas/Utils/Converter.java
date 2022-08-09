package com.meusprojetos.modeloHateoas.Utils;

import org.springframework.stereotype.Component;

import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;
import com.meusprojetos.modeloHateoas.Models.Entity.Pessoa;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.CreateEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.UpdateEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.CreatePessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.UpdatePessoaDto;

@Component
public class Converter {

	public Pessoa paraPessoa(CreatePessoaDto dto ) {
		var p = new Pessoa();
		p.setDataNascimento(dto.getDataNascimento());
		p.setNome(dto.getNome());
		return p;
	}
	
	public Pessoa paraPessoa(UpdatePessoaDto dto ) {
		var p = new Pessoa();
		p.setDataNascimento(dto.getDataNascimento());
		p.setNome(dto.getNome());
		return p;	
	}
	
	public Endereco paraEndereco(CreateEnderecoDto dto) {
		var e = new Endereco();
		e.setCep(dto.getCep());
		e.setCidade(dto.getCidade());
		e.setLogradouro(dto.getLogradouro());
		e.setNumero(dto.getNumero());
		e.setPrincipal(dto.getPrincipal());
		return e;
	}
	
	public Endereco paraEndereco(UpdateEnderecoDto dto) {
		var e = new Endereco();
		e.setCep(dto.getCep());
		e.setCidade(dto.getCidade());
		e.setLogradouro(dto.getLogradouro());
		e.setNumero(dto.getNumero());
		return e;
	}
	
}
