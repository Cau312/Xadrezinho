package xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Piece;

public class ChessPiece extends Piece{

	private Color cor;

	public ChessPiece(Board tabu, Color cor) {
		super(tabu);
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}
	
}
