package xadrez;

import java.util.ArrayList;
import java.util.List;

import jogoTabuleiro.Board;
import jogoTabuleiro.Piece;
import jogoTabuleiro.Position;
import peças.xadrez.Bispo;
import peças.xadrez.Cavalo;
import peças.xadrez.Rainha;
import peças.xadrez.Rei;
import peças.xadrez.Torre;

public class ChessMatch {

	private int turn;
	private Color jogadorAtual;
	private Board tab;

	private List<Piece> pecasVivas = new ArrayList<>();
	private List<Piece> pecasMortas = new ArrayList<>();

	public ChessMatch() {
		tab = new Board(8, 8);
		turn = 1;
		jogadorAtual = Color.BRANCO;
		inicioPartida();
	}

	public int getTurn() {
		return turn;
	}

	public Color getJogador() {
		return jogadorAtual;
	}

	public void setJogador(Color corz) {
		jogadorAtual = corz;
	}

	public void proximoTurno() {
		turn++;
		jogadorAtual = (jogadorAtual == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
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

	public ChessPiece moverPecaXadrez(ChessPosition posiIni, ChessPosition posiFin) {
		Position inicio = posiIni.toPosition();
		Position fim = posiFin.toPosition();
		testarPosiIni(inicio);
		testarPosiFin(inicio, fim);
		Piece pecaCapt = fazerMovimento(inicio, fim);
		proximoTurno();

		return (ChessPiece) pecaCapt;
	}
<<<<<<< Updated upstream
	
	private void testarPosiIni(Position posi){
		if(!tab.pecaExiste(posi)) {
			throw new ChessException("Essa Peça Não Existe :(");
		}
		if(!tab.getPeca(posi).existePossibilidade()) {
=======

	private void testarPosiIni(Position posi) {
		if (!tab.pecaExiste(posi)) {
			throw new ChessException("Essa Peça Não Existe :(");
		}
		if (jogadorAtual != ((ChessPiece) tab.getPeca(posi)).getCor()) {
			throw new ChessException("Essa peça não é sua seu retardado");
		}
		if (!tab.getPeca(posi).existePossibilidade()) {
>>>>>>> Stashed changes
			throw new ChessException("Não Existem Movimentos Possiveis :(");
		}
	}

	private void testarPosiFin(Position ini, Position fin) {
		if (!tab.getPeca(ini).movimentoPossivel(fin)) {
			throw new ChessException("A sei la vei são 5 da manhã porra");
		}
	}

	private Piece fazerMovimento(Position source, Position target) {
		Piece p = tab.removerPeca(source);
		Piece pecaCapt = tab.removerPeca(target);
		tab.colocarPeca(p, target);
		if (pecaCapt != null) {
			pecasVivas.remove(pecaCapt);
			pecasMortas.add(pecaCapt);
		}
		return pecaCapt;
	}

	private void colocarNovaPeca(char colunas, int linhas, ChessPiece piece) {
		pecasVivas.add(piece);
		tab.colocarPeca(piece, new ChessPosition(linhas, colunas).toPosition());
	}

	public boolean[][] movimentosPossi(ChessPosition suz) {
		Position p = suz.toPosition();
		testarPosiIni(p);
		return tab.getPeca(p).movimentosPossiveis();
	}

	private void inicioPartida() {
		colocarNovaPeca('a', 8, new Torre(tab, Color.PRETO));
		colocarNovaPeca('b', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('c', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('d', 8, new Rainha(tab, Color.PRETO));
		colocarNovaPeca('e', 8, new Rei(tab, Color.PRETO));
		colocarNovaPeca('f', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('g', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('h', 8, new Torre(tab, Color.PRETO));
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
		colocarNovaPeca('a', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('b', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('c', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('d', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('e', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('f', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('g', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('h', 7, new Peao(tab, Color.PRETO));
<<<<<<< Updated upstream
		
		
		
=======

>>>>>>> Stashed changes
		colocarNovaPeca('a', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('b', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('c', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('d', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('e', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('f', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('g', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('h', 2, new Peao(tab, Color.BRANCO));
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
		colocarNovaPeca('a', 1, new Torre(tab, Color.BRANCO));
		colocarNovaPeca('b', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('d', 1, new Rainha(tab, Color.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tab, Color.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tab, Color.BRANCO));
<<<<<<< Updated upstream
		
		
		
=======
>>>>>>> Stashed changes
	}

}
