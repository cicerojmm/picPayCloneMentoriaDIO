package br.com.dio.picpayclone.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.service.ITransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends ResourceBase<TransacaoDTO> {

	@Autowired
	private ITransacaoService transacaoService;

	@PostMapping
	@CacheEvict(cacheNames = "Transacoes", allEntries = true)
	public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO,
			UriComponentsBuilder uriBuilder) {
		TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
		String path = "/transacoes/{codigo}";
		return responderItemCriadoComURI(transacaoRetornoDTO, uriBuilder, path, transacaoRetornoDTO.getCodigo());
	}

	@GetMapping
	@Cacheable(cacheNames = "Transacoes", key = "#root.method.name")
	public Page<TransacaoDTO> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao,
			@RequestParam String login) {
		Page<TransacaoDTO> transacoes = transacaoService.listar(paginacao, login);
		return transacoes;
	}

}
