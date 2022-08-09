package com.meusprojetos.modeloHateoas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meusprojetos.modeloHateoas.Services.EnderecoService;
import com.meusprojetos.modeloHateoas.Services.PessoaService;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.CreatePessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.GetPessoaDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.PessoaDtos.UpdatePessoaDto;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private EnderecoService enderecoService;
	
	
	@GetMapping
	public ResponseEntity<PagedModel<GetPessoaDto>> listar(@PageableDefault(page = 0, size = 10) Pageable page) {
		return ResponseEntity.ok(pessoaService.listar(page));
	}

	@GetMapping("/{idPessoa}")
	public ResponseEntity<GetPessoaDto> buscar(@PathVariable Long idPessoa) {
		return ResponseEntity.ok(pessoaService.buscar(idPessoa));
	}

	@PostMapping
	public ResponseEntity<GetPessoaDto> adicionar(@RequestBody CreatePessoaDto dto) {
		return ResponseEntity.ok(pessoaService.adicionar(dto));
	}

	@PutMapping("/{idPessoa}")
	public ResponseEntity<GetPessoaDto> editar(@PathVariable Long idPessoa, @RequestBody UpdatePessoaDto dto){

		var pessoa = pessoaService.editar(idPessoa, dto);
		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping("/{idPessoa}")
	public ResponseEntity<?> delete(@PathVariable Long idPessoa) {
		var mensagem = pessoaService.delete(idPessoa);

		return ResponseEntity.ok(mensagem);
	}
	
	@GetMapping("/{idPessoa}/endereco")
	public ResponseEntity<PagedModel<GetEnderecoDto>> enderecosDaPessoa(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable Long idPessoa){
		return ResponseEntity.ok(enderecoService.enderecosDaPessoa(pageable, idPessoa));
	}

}
