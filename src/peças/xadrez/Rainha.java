package peças.xadrez;

import jogoTabuleiro.Board;
import xadrez.ChessPiece;
import xadrez.Color;

public class Rainha extends ChessPiece{

	public Rainha(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "Q";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return monke;
	}
}