package br.com.dio.picpayclone.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CartaoCreditoDTO {

	@NotBlank
	private String bandeira;

	@NotBlank
	private String codigoSeguranca;

	@NotBlank
	private String dataExpiracao;

	@NotBlank
	private String nomeTitular;

	private String numeroToken;

	private UsuarioDTO usuario;

	private Boolean isSalva = false;

}
