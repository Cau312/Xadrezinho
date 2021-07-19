package peças.xadrez;

import jogoTabuleiro.Board;
import xadrez.ChessPiece;
import xadrez.Color;

public class Torre extends ChessPiece{

	public Torre(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "T";
	}
	
}
