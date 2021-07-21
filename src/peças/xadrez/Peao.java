package peças.xadrez;

import jogoTabuleiro.Board;
import xadrez.ChessPiece;
import xadrez.Color;

public class Peao extends ChessPiece{

	public Peao(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return monke;
	}
}
