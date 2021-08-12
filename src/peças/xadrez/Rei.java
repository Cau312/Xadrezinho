package pe�as.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.Color;

public class Rei extends ChessPiece {

	private ChessMatch partid;

	public Rei(Board tabu, Color cor, ChessMatch parti) {
		super(tabu, cor);
		partid = parti;
		// TODO Auto-generated constructor stub
	}

	private boolean testeTorreS(Position posi) {

		ChessPiece p = (ChessPiece) getBoard().getPeca(posi);

		return p != null && p instanceof Torre && p.getCor() == getCor() && p.getMovimentosQ() == 0;

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

		p.setPosi(posi��o.getLinha() - 1, posi��o.getColuna());

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() - 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posi��o.getLinha(), posi��o.getColuna() + 1);

		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p))
				|| (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posi��o.getLinha() + 1, posi��o.getColuna());

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

		// Area Especial Come�o

		if (getMovimentosQ() == 0 && !partid.getCheck()) {

			Position posTD = new Position(posi��o.getLinha(), posi��o.getColuna() + 3);
			Position posTE = new Position(posi��o.getLinha(), posi��o.getColuna() - 4);

			if (testeTorreS(posTD)) {

				Position p1D = new Position(posi��o.getLinha(), posi��o.getColuna() + 1);
				Position p2D = new Position(posi��o.getLinha(), posi��o.getColuna() + 2);

				if (getBoard().getPeca(p1D) == null && getBoard().getPeca(p2D) == null) {
					monke[posi��o.getLinha()][posi��o.getColuna() + 2] = true;
				}
			}

			if (testeTorreS(posTE)) {

				Position p1E = new Position(posi��o.getLinha(), posi��o.getColuna() - 1);
				Position p2E = new Position(posi��o.getLinha(), posi��o.getColuna() - 2);
				Position p3E = new Position(posi��o.getLinha(), posi��o.getColuna() - 3);

				if (getBoard().getPeca(p1E) == null && getBoard().getPeca(p2E) == null
						&& getBoard().getPeca(p3E) == null) {
					monke[posi��o.getLinha()][posi��o.getColuna() - 2] = true;
				}

			}

		}

		// Area Especial Fim

		return monke;
	}
}
