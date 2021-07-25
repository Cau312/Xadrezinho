package peças.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Torre extends ChessPiece {

	public Torre(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		// cima
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
<<<<<<< Updated upstream
		
		
=======

>>>>>>> Stashed changes
		p.setPosi(posição.getLinha() - 1, posição.getColuna());
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setPosi(posição.getLinha(), posição.getColuna() - 1);
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posição.getLinha(), posição.getColuna() + 1);
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posição.getLinha() + 1, posição.getColuna());
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		return monke;
	}
}
