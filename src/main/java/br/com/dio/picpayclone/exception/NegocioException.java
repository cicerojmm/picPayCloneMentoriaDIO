package br.com.dio.picpayclone.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -7507642233804283142L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}

	public NegocioException(String mensagem, Exception exception) {
		super(mensagem, exception);
	}

	
}
