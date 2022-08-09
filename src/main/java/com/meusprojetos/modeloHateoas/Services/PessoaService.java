package com.meusprojetos.modeloHateoas.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import com.meusprojetos.modeloHateoas.Assemblers.PessoaRepresentationAssembler;
import com.meusprojetos.modeloHateoas.Exceptions.Erros.ExceptionRecursoNaoEncontrado;
import com.meusprojetos.modeloHateoas.Models.Entity.Pessoa;
import com.meusprojetos.modeloHateoas.Models.Repository.PessoaRepository;
import com.meusprojetos.modeloHateoas.Utils.Converter;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.CreatePessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.GetPessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.UpdatePessoaDto;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private Converter converter;
	@Autowired
	private PessoaRepresentationAssembler pessoaRepresentationAssembler;
	
	@Autowired
	private PagedResourcesAssembler<Pessoa> pagedResourcesAssembler;

	public PagedModel<GetPessoaDto> listar(Pageable page) {
		var listaPessoas = pessoaRepository.findAll(page);
		return pagedResourcesAssembler.toModel(listaPessoas, pessoaRepresentationAssembler);
	}

	@Transactional
	public GetPessoaDto adicionar(CreatePessoaDto dto) {
		var pessoa = converter.paraPessoa(dto);
		return pessoaRepresentationAssembler.toModel(pessoaRepository.save(pessoa));
	}

	@Transactional
	public GetPessoaDto editar(Long idPessoa, UpdatePessoaDto dto) {
		var pessoa = pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id pessos é inválido"));
		return pessoaRepresentationAssembler.toModel(atualizaPessoa(dto, pessoa));
	}

	public GetPessoaDto buscar(Long idPessoa) {
		var pessoa = pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id pessoa é inválido"));
		return pessoaRepresentationAssembler.toModel(pessoa);
	}

	@Transactional
	public String delete(Long idPessoa) {
		try {
			pessoaRepository.deleteById(idPessoa);
			return "Pessoa excluida com sucesso";
		} catch (Exception e) {
			throw new ExceptionRecursoNaoEncontrado("id pessoa é inválido");
		}
	}
	
	@Transactional
	private Pessoa atualizaPessoa(UpdatePessoaDto dto, Pessoa pessoa) {
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setNome(dto.getNome());
		return pessoaRepository.save(pessoa);
	}
}
