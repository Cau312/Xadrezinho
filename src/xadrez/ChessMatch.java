package xadrez;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

import jogoTabuleiro.Board;
import jogoTabuleiro.Piece;
import jogoTabuleiro.Position;
import pe�as.xadrez.Bispo;
import pe�as.xadrez.Cavalo;
import pe�as.xadrez.Rainha;
import pe�as.xadrez.Rei;
import pe�as.xadrez.Torre;

public class ChessMatch {

<<<<<<< HEAD
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
	private int turn;
	private Color jogadorAtual;
	private Board tab;
	private boolean check;

	private List<Piece> pecasVivas = new ArrayList<>();
	private List<Piece> pecasMortas = new ArrayList<>();

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

	public ChessPiece[][] getPe�as() {

		ChessPiece[][] Pe�asX = new ChessPiece[tab.getLinhas()][tab.getColunas()];

		for (int l = 0; l < tab.getLinhas(); l++) {
			for (int c = 0; c < tab.getColunas(); c++) {

				Pe�asX[l][c] = (ChessPiece) tab.getPeca(l, c);

			}
		}
		return Pe�asX;
	}

<<<<<<< HEAD
	public boolean getCheck() {
		return check;
	}
	
=======
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
	public ChessPiece moverPecaXadrez(ChessPosition posiIni, ChessPosition posiFin) {
		Position inicio = posiIni.toPosition();
		Position fim = posiFin.toPosition();
		testarPosiIni(inicio);
		testarPosiFin(inicio, fim);
		Piece pecaCapt = fazerMovimento(inicio, fim);
<<<<<<< HEAD
		
		if(existeCheck(jogadorAtual)) {
		
			desfazerMovimento(inicio, fim, pecaCapt);
			
			System.out.println(ANSI_RED + "Vc � imbecil ? se n�o pode se botar em cheque porra");
			throw new ChessException("ChessMatch - public ChessPiece moverPecaXadrez" + ANSI_RESET);
		}
		
		check = (existeCheck(oponente(jogadorAtual))) ? true : false;
		
		proximoTurno();
		
		return (ChessPiece) pecaCapt;
	}

	private void testarPosiIni(Position posi) {
		if (!tab.pecaExiste(posi)) {
			System.out.println(ANSI_RED + "Essa Pe�a N�o Existe :(");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
		}
		if (jogadorAtual != ((ChessPiece) tab.getPeca(posi)).getCor()) {
			System.out.println(ANSI_RED + "Essa pe�a n�o � sua seu retardado");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
		}
		if (!tab.getPeca(posi).existePossibilidade()) {
			System.out.println(ANSI_RED + "N�o Existem Movimentos Possiveis :(");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
=======
		proximoTurno();

		return (ChessPiece) pecaCapt;
	}
<<<<<<< Updated upstream
	
	private void testarPosiIni(Position posi){
		if(!tab.pecaExiste(posi)) {
			throw new ChessException("Essa Pe�a N�o Existe :(");
		}
		if(!tab.getPeca(posi).existePossibilidade()) {
=======

	private void testarPosiIni(Position posi) {
		if (!tab.pecaExiste(posi)) {
			throw new ChessException("Essa Pe�a N�o Existe :(");
		}
		if (jogadorAtual != ((ChessPiece) tab.getPeca(posi)).getCor()) {
			throw new ChessException("Essa pe�a n�o � sua seu retardado");
		}
		if (!tab.getPeca(posi).existePossibilidade()) {
>>>>>>> Stashed changes
			throw new ChessException("N�o Existem Movimentos Possiveis :(");
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		}
	}

	private void testarPosiFin(Position ini, Position fin) {
		if (!tab.getPeca(ini).movimentoPossivel(fin)) {
<<<<<<< HEAD
			System.out.println(ANSI_RED + "A sei la vei s�o 5 da manh� porra");
			throw new ChessException("ChessMatch - private void testarPosiFin" + ANSI_RESET);
		}
	}

	private void desfazerMovimento(Position ini, Position fin, Piece morto) {
		Piece p = tab.removerPeca(fin);
		tab.colocarPeca(p, ini);

		if (morto != null) {
			tab.colocarPeca(morto, fin);
			pecasMortas.remove(morto);
			pecasVivas.add(morto);
			
		}
	}

	private Color oponente(Color cor) {
		return (cor == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
	}

	private ChessPiece rei(Color cor) {

		List<Piece> list = pecasVivas.stream().filter(x -> ((ChessPiece)x).getCor() == cor)
				.collect(Collectors.toList());

		for (Piece p : list) {
			if (p instanceof Rei) {
				return (ChessPiece) p;
			}
		}
		System.out.println(ANSI_RED + "N�o tem rei meu chapa");
		throw new IllegalStateException("ChessMatch - private ChessPiece rei" + ANSI_RESET);
	}

	private boolean existeCheck(Color cor) {
		Position posicaoRei = rei(cor).getChessPosition().toPosition();
		List<Piece> pecasInimigas = pecasVivas.stream().filter(x -> ((ChessPiece)x).getCor() == oponente(cor))
				.collect(Collectors.toList());
		for (Piece p : pecasInimigas) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}

=======
			throw new ChessException("A sei la vei s�o 5 da manh� porra");
		}
	}

>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
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
<<<<<<< HEAD

=======
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		colocarNovaPeca('a', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('b', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('c', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('d', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('e', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('f', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('g', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('h', 7, new Peao(tab, Color.PRETO));
<<<<<<< HEAD

=======
<<<<<<< Updated upstream
		
		
		
=======

>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		colocarNovaPeca('a', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('b', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('c', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('d', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('e', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('f', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('g', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('h', 2, new Peao(tab, Color.BRANCO));
<<<<<<< HEAD

=======
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		colocarNovaPeca('a', 1, new Torre(tab, Color.BRANCO));
		colocarNovaPeca('b', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('d', 1, new Rainha(tab, Color.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tab, Color.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tab, Color.BRANCO));
<<<<<<< Updated upstream
		
<<<<<<< HEAD
=======
		
		
=======
>>>>>>> Stashed changes
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
	}

}
