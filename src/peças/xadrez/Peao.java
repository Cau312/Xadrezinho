package pe�as.xadrez;

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
<<<<<<< Updated upstream
		// cima
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
		
		
		
		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}


		// esquerda
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() - 1);
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() + 1);
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna());
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		
=======

		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);

		// cima
		if (getCor() == Color.BRANCO) {
			p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());
			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna() - 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna() + 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

		}

		// baixo
		if (getCor() == Color.PRETO) {

			p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna());
			if (!temPecaInimiga(p)) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna() + 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

			p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna() - 1);

			if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))) {
				if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
						|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
					monke[p.getLinha()][p.getColuna()] = true;
				}
			}

		}
>>>>>>> Stashed changes

		return monke;
	}
}
