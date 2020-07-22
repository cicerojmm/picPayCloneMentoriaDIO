package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.service.IUsuarioService;

@Component
public class TransacaoConversor extends ConversorBase<Transacao, TransacaoDTO> {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public TransacaoDTO converterEntidadeParaDto(Transacao entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entidade, TransacaoDTO.class);
	}

	@SuppressWarnings("unchecked")
	public Page<TransacaoDTO> converterPageEntidadeParaDto(Page<Transacao> entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Page<Transacao>, Page<TransacaoDTO>>() {
			@Override
			protected void configure() {
			}
		});

		return modelMapper.map(entidade, Page.class);
	}
	
	@Override
	public Transacao converterDtoParaEntidade(TransacaoDTO dto) {
		return Transacao.builder()
				.codigo(dto.getCodigo())
				.dataHora(dto.getDataHora())
				.valor(dto.getValor())
				.destino(usuarioService.consultarEntidade(dto.getDestino().getLogin()))
				.origem(usuarioService.consultarEntidade(dto.getOrigem().getLogin()))
				.build();
	}

}
