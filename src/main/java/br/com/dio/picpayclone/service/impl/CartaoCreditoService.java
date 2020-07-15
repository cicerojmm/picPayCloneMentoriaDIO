package br.com.dio.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.conversor.CartaoCreditoConversor;
import br.com.dio.picpayclone.dto.CartaoCreditoDTO;
import br.com.dio.picpayclone.modelo.CartaoCredito;
import br.com.dio.picpayclone.repository.CartaoCreditoRepository;
import br.com.dio.picpayclone.service.ICartaoCreditoService;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class CartaoCreditoService implements ICartaoCreditoService {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

	@Autowired
	private CartaoCreditoConversor cartaoCreditoConversor;
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
		CartaoCreditoDTO cartaoCreditoRetorno = null;
		if (cartaoCreditoDTO.getIsSalva()) {
			CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
			usuarioService.validar(cartaoCredito.getUsuario());
			CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
			cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
		}

		return cartaoCreditoRetorno;
	}

}
