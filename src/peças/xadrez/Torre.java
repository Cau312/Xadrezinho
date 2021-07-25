package pe�as.xadrez;

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
		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() - 1);
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() + 1);
		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getBoard().posicaoExiste(p) && temPecaInimiga(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna());
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
