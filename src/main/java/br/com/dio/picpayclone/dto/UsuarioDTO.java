package br.com.dio.picpayclone.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UsuarioDTO {

	@NotBlank
	private String login;

	private String senha;

	private String email;

	private String nomeCompleto;

	private String cpf;

	private LocalDate dataNascimento;

	private String numeroTelefone;
	
	private Double saldo;

}
