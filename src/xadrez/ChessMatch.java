package xadrez;

import jogoTabuleiro.Board;
import jogoTabuleiro.Piece;
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

				PeçasX[l][c] = (ChessPiece) tab.getPeca(l, c);

			}
		}
		return PeçasX;
	}
	
	public ChessPiece moverPecaXadrez(ChessPosition posiIni, ChessPosition posiFin){
		Position inicio = posiIni.toPosition();
		Position fim = posiFin.toPosition();
		testarPosiIni(inicio);
		Piece pecaCapt = fazerMovimento(inicio, fim);
		return (ChessPiece)pecaCapt;
	}
	
	private void testarPosiIni(Position posi){
		if(!tab.pecaExiste(posi)) {
			throw new ChessException("Vai se fuder");
		}
	}
	
	private Piece fazerMovimento(Position posiIni, Position posiFin) {
		Piece p = tab.removerPeca(posiIni);
		Piece pecaCapt = tab.removerPeca(posiFin);
		tab.colocarPeca(p, posiFin);
		return pecaCapt;
	}
	
	private void colocarNovaPeca(char coluna, int linha, ChessPiece piece) {
		tab.colocarPeca(piece, new ChessPosition(linha, coluna).toPosition());
	}
	
	/*
	private Piece detectarPeca(char coluna, int linha) {
		
		return tab.getPeca(new ChessPosition(linha, coluna).toPosition();
	}
	*/
	
	private void inicioPartida() {
		colocarNovaPeca('a', 8, new Torre(tab, Color.PRETO));
		colocarNovaPeca('b', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('c', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('d', 8, new Rainha(tab, Color.PRETO));
		colocarNovaPeca('e', 8, new Rei(tab, Color.PRETO));
		colocarNovaPeca('f', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('g', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('h', 8, new Torre(tab, Color.PRETO));
		
		for(int i = 0; i<8; i++) {
			tab.colocarPeca(new Peao(tab, Color.PRETO), new Position(1, i));
			}
		
		
		colocarNovaPeca('a', 1, new Torre(tab, Color.BRANCO));
		colocarNovaPeca('b', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('d', 1, new Rainha(tab, Color.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tab, Color.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tab, Color.BRANCO));
		
		for(int i = 0; i<8; i++) {
		tab.colocarPeca(new Peao(tab, Color.BRANCO), new Position(6, i));
		}
	}

}
