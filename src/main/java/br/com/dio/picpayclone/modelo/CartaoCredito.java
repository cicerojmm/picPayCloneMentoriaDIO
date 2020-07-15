package br.com.dio.picpayclone.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CARTAO_CREDITO")
public class CartaoCredito extends EntidadeBase {

	@Column(name = "CC_NUMERO", nullable = false)
	private String numero;

	@Column(name = "CC_BANDEIRA", nullable = false)
	private String bandeira;

	@Column(name = "CC_TOKEN")
	private String numeroToken;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "CC_USUARIO_ID", nullable = false)
	private Usuario usuario;

}
