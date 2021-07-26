package xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Piece;
import jogoTabuleiro.Position;

public abstract class ChessPiece extends Piece {

	private Color cor;

	public ChessPiece(Board tabu, Color cor) {
		super(tabu);
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}

	public ChessPosition getChessPosition() {
		
		return ChessPosition.fromPosition(posição);
	}
	
	protected boolean temPecaInimiga(Position posi) {
		ChessPiece p = (ChessPiece) getBoard().getPeca(posi);
		return p != null && p.getCor() != cor;
	}

	protected boolean mesmaCor(Position posi) {
		ChessPiece p = (ChessPiece) getBoard().getPeca(posi);
		return p != null && p.getCor() == cor;
	}

	protected boolean pecaPreta(Position posi) {
		ChessPiece p = (ChessPiece) getBoard().getPeca(posi);
		return p != null && p.getCor() == Color.PRETO;
	}

	protected boolean pecaBranca(Position posi) {
		ChessPiece p = (ChessPiece) getBoard().getPeca(posi);
		return p != null && p.getCor() == Color.BRANCO;
	}
	

}
