package peças.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Peao extends ChessPiece {

	public Peao(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
		Position p2 = new Position(posição.getLinha() - 1, posição.getColuna());

		// cima
		if (getCor() == Color.BRANCO) {

			p.setPosi(posição.getLinha() - 1, posição.getColuna());
			p2.setPosi(posição.getLinha() - 2, posição.getColuna());

			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					if ((getBoard().posicaoExiste(p2) && temPecaInimiga(p2) && (getMovimentosQ() == 0))
							|| (getBoard().posicaoExiste(p2) && mesmaCor(p2) != true) && (getMovimentosQ() == 0)) {
						monke[p.getLinha()][p.getColuna()] = true;
						monke[p2.getLinha()][p2.getColuna()] = true;
					} else {
						monke[p.getLinha()][p.getColuna()] = true;
					}
				}
			}

			p.setPosi(posição.getLinha() - 1, posição.getColuna() - 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posição.getLinha() - 1, posição.getColuna() + 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

		}

		// baixo
		if (getCor() == Color.PRETO) {

			p.setPosi(posição.getLinha() + 1, posição.getColuna());
			p2.setPosi(posição.getLinha() + 2, posição.getColuna());

			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					if ((getBoard().posicaoExiste(p2) && temPecaInimiga(p2) && (getMovimentosQ() == 0))
							|| (getBoard().posicaoExiste(p2) && mesmaCor(p2) != true) && (getMovimentosQ() == 0)) {
						monke[p.getLinha()][p.getColuna()] = true;
						monke[p2.getLinha()][p2.getColuna()] = true;
					} else {
						monke[p.getLinha()][p.getColuna()] = true;
					}
				}
			}

			p.setPosi(posição.getLinha() + 1, posição.getColuna() + 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posição.getLinha() + 1, posição.getColuna() - 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

		}

		return monke;
	}
}
