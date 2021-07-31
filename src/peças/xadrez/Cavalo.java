package peças.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Cavalo extends ChessPiece {

	public Cavalo(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "C";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
		
		p.setPosi(posição.getLinha() + 2, posição.getColuna() + 1);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() + 2, posição.getColuna() - 1);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() - 2, posição.getColuna() + 1);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() - 2, posição.getColuna() - 1);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() + 1, posição.getColuna() + 2);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() - 1, posição.getColuna() + 2);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() + 1, posição.getColuna() - 2);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setPosi(posição.getLinha() - 1, posição.getColuna() - 2);
		if (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		
		
		return monke;
	}
}