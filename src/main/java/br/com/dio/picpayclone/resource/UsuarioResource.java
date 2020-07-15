package br.com.dio.picpayclone.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO> {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/{login}/saldo")
	public ResponseEntity<UsuarioDTO> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao,
			@PathVariable String login) {
		UsuarioDTO usuarioDTO = usuarioService.consultarSaldo(login);
		return responderSucessoComItem(usuarioDTO);
	}

}
