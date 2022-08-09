package com.meusprojetos.modeloHateoas.Services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meusprojetos.modeloHateoas.Assemblers.EnderecoRepresentationAssembler;
import com.meusprojetos.modeloHateoas.Assemblers.PessoaRepresentationAssembler;
import com.meusprojetos.modeloHateoas.Exceptions.Erros.ExceptionRecursoNaoEncontrado;
import com.meusprojetos.modeloHateoas.Models.Entity.Endereco;
import com.meusprojetos.modeloHateoas.Models.Repository.EnderecoRepository;
import com.meusprojetos.modeloHateoas.Models.Repository.PessoaRepository;
import com.meusprojetos.modeloHateoas.Utils.Converter;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.CreateEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.UpdateEnderecoDto;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private Converter converter;
	@Autowired
	private EnderecoRepresentationAssembler enderecoRepresentationAssembler;
	@Autowired
	private PagedResourcesAssembler<Endereco> pagedResourcesAssembler;


	public PagedModel<GetEnderecoDto> listar(Pageable pageable) {
		var pageEndereco = enderecoRepository.findAll(pageable);
		return pagedResourcesAssembler.toModel(pageEndereco, enderecoRepresentationAssembler);
	}

	public GetEnderecoDto adicionar(CreateEnderecoDto dto) {
		var endereco = converter.paraEndereco(dto);
		var p = pessoaRepository.findById(dto.getPessoaId()).orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id pessos é inválido"));	
		endereco.setPessoa(p);
		endereco = enderecoRepository.save(endereco);

		return enderecoRepresentationAssembler.toModel(endereco);
	}

	public GetEnderecoDto buscar(Long idEndereco) {
		var endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id do endereco é inválido"));
		
		return enderecoRepresentationAssembler.toModel(endereco);
	}

	public GetEnderecoDto editar(Long idEndereco, UpdateEnderecoDto dto) {
		var endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id dop endereco inválido"));
		endereco = atualizaEndereco(dto, endereco);
		
		return enderecoRepresentationAssembler.toModel(endereco);
	}

	private Endereco atualizaEndereco(UpdateEnderecoDto dto, Endereco endereco) {
		endereco.setCep(dto.getCep());
		endereco.setCidade(dto.getCidade());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());

		return enderecoRepository.save(endereco);
	}

	public String deletar(Long idEndereco) {
		
		var endereco = enderecoRepository.findById(idEndereco)
							.orElseThrow(()-> new ExceptionRecursoNaoEncontrado("id de pesso para excluir é inválido"));
		enderecoRepository.delete(endereco);

		return "Recurso excluido com sucesso";
	}

	public ResponseEntity<?> definirComoPrincipal(Long idEndereco) {
		
		var endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ExceptionRecursoNaoEncontrado("id endereco inválido"));
		var OptionalDemaisEnderecos = enderecoRepository.findByPrincipalAndPessoaId(true, endereco.getPessoa().getId());
		
		OptionalDemaisEnderecos.ifPresent(demaisEnderecos -> {
			demaisEnderecos.forEach((e)-> e.setPrincipal(false));
			enderecoRepository.saveAll(demaisEnderecos);
		});
		
		endereco.setPrincipal(true);
		enderecoRepository.save(endereco);
		
		
		
		return null;
	}

	public PagedModel<GetEnderecoDto> enderecosDaPessoa(Pageable pageable, Long idPessoa) {
		var enderecos = enderecoRepository.findAllByPessoaId(pageable, idPessoa);
		return pagedResourcesAssembler.toModel(enderecos, enderecoRepresentationAssembler);
	}

}
