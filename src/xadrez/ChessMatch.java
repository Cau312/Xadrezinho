package xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Position;
import peças.xadrez.Bispo;
import peças.xadrez.Cavalo;
import peças.xadrez.Peao;
import peças.xadrez.Rainha;
import peças.xadrez.Rei;
import peças.xadrez.Torre;

public class ChessMatch {

	private Board tab;

	public ChessMatch() {
		tab = new Board(8, 8);
		inicioPartida();
	}

	
	public ChessPiece[][] getPeças() {

		ChessPiece[][] PeçasX = new ChessPiece[tab.getLinhas()][tab.getColunas()];

		for (int l = 0; l < tab.getLinhas(); l++) {
			for (int c = 0; c < tab.getColunas(); c++) {

				PeçasX[l][c] = (ChessPiece) tab.peca(l, c);

			}
		}
		return PeçasX;
	}
	
	private void colocarNovaPeca(char coluna, int linha, ChessPiece piece) {
		tab.colocarPeca(piece, new ChessPosition(linha, coluna).toPosition());
	}
	
	private void inicioPartida() {
		colocarNovaPeca('a', 8, new Torre(tab, Color.BRANCO));
		colocarNovaPeca('b', 8,new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('c', 8,new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('d', 8,new Rainha(tab, Color.BRANCO));
		colocarNovaPeca('e', 8,new Rei(tab, Color.BRANCO));
		colocarNovaPeca('f', 8,new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('g', 8,new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('h', 8,new Torre(tab, Color.BRANCO));
		
		for(int i = 0; i<8; i++) {
			tab.colocarPeca(new Peao(tab, Color.BRANCO), new Position(1, i));
			}
		
		
		colocarNovaPeca('a', 1, new Torre(tab, Color.PRETO));
		colocarNovaPeca('b', 1,new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('c', 1,new Bispo(tab, Color.PRETO));
		colocarNovaPeca('d', 1,new Rainha(tab, Color.PRETO));
		colocarNovaPeca('e', 1,new Rei(tab, Color.PRETO));
		colocarNovaPeca('f', 1,new Bispo(tab, Color.PRETO));
		colocarNovaPeca('g', 1,new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('h', 1,new Torre(tab, Color.PRETO));
		
		for(int i = 0; i<8; i++) {
		tab.colocarPeca(new Peao(tab, Color.PRETO), new Position(6, i));
		}
	}

}
