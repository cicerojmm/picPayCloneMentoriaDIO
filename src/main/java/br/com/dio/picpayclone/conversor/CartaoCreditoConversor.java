package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.dto.CartaoCreditoDTO;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.CartaoCredito;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.modelo.Usuario;
import br.com.dio.picpayclone.service.IUsuarioService;

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
		ModelMapper modelMapper = new ModelMapper();
		Usuario usuario = usuarioService.consultar(dto.getUsuario().getLogin());
		modelMapper.addMappings(new PropertyMap<CartaoCreditoDTO, CartaoCredito>() {
			@Override
			protected void configure() {
				map().setUsuario(usuario);
			}
		});

		return modelMapper.map(dto, CartaoCredito.class);
	}

}
