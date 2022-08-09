package com.meusprojetos.modeloHateoas.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.CreateEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.GetEnderecoDto;
import com.meusprojetos.modeloHateoas.Views.Dtos.EnderecoDtos.UpdateEnderecoDto;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<PagedModel<GetEnderecoDto>> listar(@PageableDefault(page = 0, size = 10) Pageable pageable) {
		return ResponseEntity.ok(enderecoService.listar(pageable));
	}

	@GetMapping("/{idEndereco}")
	public ResponseEntity<GetEnderecoDto> buscar(@PathVariable Long idEndereco) {
		return ResponseEntity.ok(enderecoService.buscar(idEndereco));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionar(@RequestBody CreateEnderecoDto dto) {
		System.out.println(dto);
		return ResponseEntity.ok(enderecoService.adicionar(dto));

	}

	@PutMapping("/{idEndereco}")
	@Transactional
	public ResponseEntity<GetEnderecoDto> editar(@PathVariable Long idEndereco, @RequestBody UpdateEnderecoDto dto) {
		var mensagem = enderecoService.editar(idEndereco, dto);
		return ResponseEntity.ok(mensagem);
	}

	@DeleteMapping("/{idEndereco}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long idEndereco) {
		var mensagem = enderecoService.deletar(idEndereco);
		return ResponseEntity.ok(mensagem);
	}

	@GetMapping("/{idEndereco}/principal")
	public ResponseEntity<?> definirComoPrincipal(@PathVariable Long idEndereco){
		return enderecoService.definirComoPrincipal(idEndereco);
	}

}
