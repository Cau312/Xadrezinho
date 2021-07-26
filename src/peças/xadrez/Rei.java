package peças.xadrez;

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
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
		
		
		
		p.setPosi(posição.getLinha() - 1, posição.getColuna());
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}


		// esquerda
		p.setPosi(posição.getLinha(), posição.getColuna() - 1);
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

		p.setPosi(posição.getLinha() - 1, posição.getColuna());

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setPosi(posição.getLinha(), posição.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posição.getLinha(), posição.getColuna() + 1);
<<<<<<< HEAD

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
=======
<<<<<<< Updated upstream
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
=======

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posição.getLinha() + 1, posição.getColuna());
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posição.getLinha() + 1, posição.getColuna() + 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posição.getLinha() - 1, posição.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posição.getLinha() + 1, posição.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		p.setPosi(posição.getLinha() - 1, posição.getColuna() + 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

		return monke;
	}
}
