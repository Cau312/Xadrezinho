package xadrez;

import jogoTabuleiro.Position;

public class ChessPosition {

	private char colunas;
	private int linhas;

	public ChessPosition(int linhas, char colunas) {
		if (colunas < 'a' || colunas > 'h' || linhas < 1 || linhas > 8) {
			throw new ChessException("Valores Invalidos :( | Valore Validos: [1 - 8] e [a - h]");
		}
		this.colunas = colunas;
		this.linhas = linhas;
	}

	public char getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}

	protected Position toPosition() {
		return new Position(8 - linhas, colunas - 'a');
	}

	protected static ChessPosition toChessPosition(Position posi) {
		return new ChessPosition((8 - posi.getLinha()), (char) ('a' - posi.getColuna()));
	}

	@Override
	public String toString() {
		return "" + colunas + linhas;
	}

}
