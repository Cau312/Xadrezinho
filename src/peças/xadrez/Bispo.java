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
<<<<<<< HEAD

=======
<<<<<<< Updated upstream
		// cima
=======

>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
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

<<<<<<< HEAD
=======
<<<<<<< Updated upstream
		// esquerda
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		p.setPosi(posição.getLinha() + 1, posição.getColuna() + 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() + 1);
		}
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}

		// direita
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		p.setPosi(posição.getLinha() - 1, posição.getColuna() + 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
			p.setColuna(p.getColuna() + 1);
		}
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}

		// baixo
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		p.setPosi(posição.getLinha() + 1, posição.getColuna() - 1);

		while (getBoard().posicaoExiste(p) && !getBoard().pecaExiste(p)) {
			monke[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() - 1);
		}
<<<<<<< HEAD
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
=======
<<<<<<< Updated upstream
		if((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
	}
=======
		if ((getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		return monke;
	}

}
