package xadrez;

import jogoTabuleiro.BoardExeption;

public class ChessException extends BoardExeption {
	private static final long serialVersionUID = 1L;

	public ChessException(String msg) {
		super(msg);
	}

}