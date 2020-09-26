package br.com.dio.picpayclone.modelo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.dio.picpayclone.enums.TipoPermissao;
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
@Table(name = "USUARIOS")
public class Usuario extends EntidadeBase implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(name = "USU_LOGIN", nullable = false)
	private String login;

	@Column(name = "USU_SENHA", nullable = false)
	private String senha;

	@Column(name = "USU_EMAIL", nullable = false)
	private String email;

	@Column(name = "USU_NOME_COMPLETO", nullable = false)
	private String nomeCompleto;

	@Column(name = "USU_CPF", nullable = false)
	private String cpf;

	@Column(name = "USU_DATA_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "USU_NUMERO_TELEFONE", nullable = false)
	private String numeroTelefone;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<CartaoCredito> cartoesCredito;

	@Column(name = "USU_SALDO", nullable = false)
	private Double saldo;

	@Column(name = "USU_ATIVO", nullable = false)
	private Boolean ativo;

	@Enumerated(EnumType.STRING)
	@Column(name = "USU_PERMISSAO", nullable = false)
	private TipoPermissao permissao;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listaAutorizacoes = Arrays.asList(new SimpleGrantedAuthority(permissao.getCodigo()));
		return listaAutorizacoes;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.ativo;
	}

}
