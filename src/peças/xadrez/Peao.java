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

		// cima
		if (getCor() == Color.BRANCO) {
			p.setPosi(posição.getLinha() - 1, posição.getColuna());
			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
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
			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
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
