package pe�as.xadrez;

import jogoTabuleiro.Board;
import xadrez.ChessPiece;
import xadrez.Color;

public class Bispo extends ChessPiece{

	public Bispo(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "B";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return monke;
	}
	
}
