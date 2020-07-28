package br.com.dio.picpayclone.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

import br.com.dio.picpayclone.enums.BandeiraCartao;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CartaoCreditoDTO {

	@NotBlank
	private BandeiraCartao bandeira;

	@NotBlank
	private String codigoSeguranca;

	@NotBlank
	private String dataExpiracao;

	@NotBlank
	private String nomeTitular;
	
	private String numero;

	private String numeroToken;

	@NotNull
	private UsuarioDTO usuario;

	private Boolean isSalva = false;

}
