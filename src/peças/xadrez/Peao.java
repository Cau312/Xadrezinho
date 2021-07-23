package peças.xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import xadrez.ChessPiece;
import xadrez.Color;

public class Peao extends ChessPiece{

	public Peao(Board tabu, Color cor) {
		super(tabu, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		// cima
		boolean[][] monke = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
		
		
		
		p.setPosi(posição.getLinha() - 1, posição.getColuna());
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}


		// esquerda
		p.setPosi(posição.getLinha(), posição.getColuna() - 1);
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setPosi(posição.getLinha(), posição.getColuna() + 1);
		
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setPosi(posição.getLinha() + 1, posição.getColuna());
			
		if ((getBoard().posicaoExiste(p) && temPecaInimiga(p)) || (getBoard().posicaoExiste(p) && mesmaCor(p) != true)) {
			monke[p.getLinha()][p.getColuna()] = true;
		}
		
		

		return monke;
	}
}
