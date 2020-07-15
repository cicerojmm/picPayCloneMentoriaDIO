package br.com.dio.picpayclone.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.constantes.MensagemValidacao;
import br.com.dio.picpayclone.conversor.UsuarioConversor;
import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.exception.NegocioException;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.modelo.Usuario;
import br.com.dio.picpayclone.repository.UsuarioRepository;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioConversor usuarioConversor;

	@Override
	public UsuarioDTO consultarSaldo(String login) {
		Usuario usuario = consultar(login);
		return usuarioConversor.converterEntidadeParaDto(usuario);
	}

	@Override
	public Usuario consultar(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	@Async("asyncExecutor")
	public void atualizarSaldo(Transacao transacaoSalva) {
		usuarioRepository.updateDecrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor());
		usuarioRepository.updateIncrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor());
	}

	@Override
	public void validar(Usuario... usuarios) {

		Arrays.asList(usuarios).stream().forEach(usuario -> {
			if (usuario != null) {
				throw new NegocioException(MensagemValidacao.ERRO_USUARIO_INEXISTENTE);
			}

		});
	}

}
