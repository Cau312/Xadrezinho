package xadrez;

import jogoTabuleiro.Position;

public class ChessPosition {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	private char colunas;
	private int linhas;

	public ChessPosition(int linhas, char colunas) {
		if (colunas < 'a' || colunas > 'h' || linhas < 1 || linhas > 8) {
			System.out.println(ANSI_RED + "Valores Invalidos :( | Valore Validos: [1 - 8] e [a - h]");
			throw new ChessException("ChessPosition - public ChessPosition" + ANSI_RESET);
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

	protected static ChessPosition fromPosition(Position posi) {
		return new ChessPosition((8 - posi.getLinha()), (char) ('a' + posi.getColuna()));
	}

	@Override
	public String toString() {
		return "" + colunas + linhas;
	}

}
