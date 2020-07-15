package br.com.dio.picpayclone.service;

import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.modelo.Usuario;

public interface IUsuarioService {

	Usuario consultar(String login);
	
	UsuarioDTO consultarSaldo(String login);

	void atualizarSaldo(Transacao transacaoSalva);

	void validar(Usuario... usuarios);

}
