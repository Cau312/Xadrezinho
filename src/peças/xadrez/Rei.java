package peças.xadrez;

import jogoTabuleiro.Board;
import xadrez.ChessPiece;
import xadrez.Color;

public class Rei extends ChessPiece{

	public Rei(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "R";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return monke;
	}
}
