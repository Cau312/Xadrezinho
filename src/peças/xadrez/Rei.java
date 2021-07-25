package pe�as.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Rei extends ChessPiece {

	public Rei(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		// cima
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
<<<<<<< Updated upstream
		
		
		
		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}


		// esquerda
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() - 1);
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
=======

		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
>>>>>>> Stashed changes
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() + 1);
<<<<<<< Updated upstream
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
=======

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
>>>>>>> Stashed changes
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna());
<<<<<<< Updated upstream
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		
=======

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna() + 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna() + 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
>>>>>>> Stashed changes

		return monke;
	}
}
