package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.dto.CartaoCreditoDTO;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.CartaoCredito;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.service.IUsuarioService;
import br.com.dio.picpayclone.utils.CartaoCreditoUtil;

@Component
public class CartaoCreditoConversor extends ConversorBase<CartaoCredito, CartaoCreditoDTO> {

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public CartaoCreditoDTO converterEntidadeParaDto(CartaoCredito entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entidade, CartaoCreditoDTO.class);
	}

	@Override
	public CartaoCredito converterDtoParaEntidade(CartaoCreditoDTO dto) {
		return CartaoCredito
				.builder()
				.bandeira(dto.getBandeira())
				.numero(CartaoCreditoUtil.mascarar(dto.getNumero()))
				.numeroToken(dto.getNumeroToken())
				.usuario(usuarioService.consultarEntidade(dto.getUsuario().getLogin()))
				.build();
	}

}
