package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.Transacao;

@Component
public class TransacaoConversor extends ConversorBase<Transacao, TransacaoDTO> {

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

	@Override
	public Transacao converterDtoParaEntidade(TransacaoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<TransacaoDTO, Transacao>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(dto, Transacao.class);
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

}
