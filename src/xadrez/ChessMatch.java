package xadrez;

import jogoTabuleiro.Board;

public class ChessMatch {

	private Board Tab;

	public ChessMatch() {
		Tab = new Board(8, 8);
	}

	
	public ChessPiece[][] getPeças() {

		ChessPiece[][] PeçasX = new ChessPiece[Tab.getLinhas()][Tab.getColunas()];

		for (int l = 0; l < Tab.getLinhas(); l++) {
			for (int c = 0; c < Tab.getColunas(); c++) {

				PeçasX[l][c] = (ChessPiece) Tab.peça(l, c);

			}
		}
		return PeçasX;
	}

}
