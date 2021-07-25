package peças.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Bispo extends ChessPiece {

	public Bispo(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);

		p.setPosi(posição.getLinha() - 1, posição.getColuna() - 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
			p.setColuna(p.getColuna() - 1);
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		
		p.setPosi(posição.getLinha() + 1, posição.getColuna() + 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() + 1);
		}
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}

		
		p.setPosi(posição.getLinha() - 1, posição.getColuna() + 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
			p.setColuna(p.getColuna() + 1);
		}
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}

		
		p.setPosi(posição.getLinha() + 1, posição.getColuna() - 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() - 1);
		}
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}
		return monke;
	}

}
