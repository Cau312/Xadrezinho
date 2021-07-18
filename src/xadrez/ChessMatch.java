package xadrez;

import jogoTabuleiro.Board;

public class ChessMatch {

	private Board Tab;

	public ChessMatch() {
		Tab = new Board(8, 8);
	}

	
	public ChessPiece[][] getPe�as() {

		ChessPiece[][] Pe�asX = new ChessPiece[Tab.getLinhas()][Tab.getColunas()];

		for (int l = 0; l < Tab.getLinhas(); l++) {
			for (int c = 0; c < Tab.getColunas(); c++) {

				Pe�asX[l][c] = (ChessPiece) Tab.pe�a(l, c);

			}
		}
		return Pe�asX;
	}

}
