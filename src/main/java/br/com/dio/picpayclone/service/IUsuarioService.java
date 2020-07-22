package br.com.dio.picpayclone.service;

import java.util.List;

import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.modelo.Usuario;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);
	
	UsuarioDTO consultar(String login);

	void atualizarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito);

	void validar(Usuario... usuarios);

	List<UsuarioDTO> listar(String login);

}
