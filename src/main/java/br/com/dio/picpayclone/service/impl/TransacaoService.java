package br.com.dio.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.conversor.TransacaoConversor;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.repository.TransacaoRepository;
import br.com.dio.picpayclone.service.ICartaoCreditoService;
import br.com.dio.picpayclone.service.ITransacaoService;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class TransacaoService implements ITransacaoService {

	@Autowired
	private TransacaoConversor transacaoConversor;

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ICartaoCreditoService cartaoCreditoService;

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
		Transacao transacaoSalva = salvar(transacaoDTO);
		cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
		usuarioService.atualizarSaldo(transacaoSalva, transacaoDTO.getIsCartaoCredito());
		return transacaoConversor.converterEntidadeParaDto(transacaoSalva);
	}

	private Transacao salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
		usuarioService.validar(transacao.getDestino(), transacao.getDestino());
		return transacaoRepository.save(transacao);
	}

	@Override
	public Page<TransacaoDTO> listar(Pageable paginacao, String loginUsuario) {
		Page<Transacao> transacaoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(loginUsuario, loginUsuario, paginacao);
		return transacaoConversor.converterPageEntidadeParaDto(transacaoes);
	}

}
