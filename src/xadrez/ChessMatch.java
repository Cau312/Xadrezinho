package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	private int turn;
	private Color jogadorAtual;
	private Board tab;
	private boolean check;
	private boolean mariele;

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

	public boolean getCheck() {
		return check;
	}

	public ChessPiece moverPecaXadrez(ChessPosition posiIni, ChessPosition posiFin) {
		Position inicio = posiIni.toPosition();
		Position fim = posiFin.toPosition();
		testarPosiIni(inicio);
		testarPosiFin(inicio, fim);
		Piece pecaCapt = fazerMovimento(inicio, fim);

		if (existeCheck(jogadorAtual)) {

			desfazerMovimento(inicio, fim, pecaCapt);

			System.out.println(ANSI_RED + "Vc é imbecil ? se não pode se botar em cheque porra");
			throw new ChessException("ChessMatch - public ChessPiece moverPecaXadrez" + ANSI_RESET);
		}

		check = (existeCheck(oponente(jogadorAtual))) ? true : false;

		if (existeCheckMate(oponente(jogadorAtual))) {
			mariele = true;
		} else {

			 proximoTurno();

		}

		return (ChessPiece) pecaCapt;
	}

	private void testarPosiIni(Position posi) {
		if (!tab.pecaExiste(posi)) {
			System.out.println(ANSI_RED + "Essa Peça Não Existe :(");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
		}
		if (jogadorAtual != ((ChessPiece) tab.getPeca(posi)).getCor()) {
			System.out.println(ANSI_RED + "Essa peça não é sua seu retardado");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
		}
		if (!tab.getPeca(posi).existePossibilidade()) {
			System.out.println(ANSI_RED + "Não Existem Movimentos Possiveis :(");
			throw new ChessException("ChessMatch - private void testarPosiIni" + ANSI_RESET);
		}
	}

	private void testarPosiFin(Position ini, Position fin) {
		if (!tab.getPeca(ini).movimentoPossivel(fin)) {
			System.out.println(ANSI_RED + "A sei la vei são 5 da manhã porra");
			throw new ChessException("ChessMatch - private void testarPosiFin" + ANSI_RESET);
		}
	}

	private void desfazerMovimento(Position ini, Position fin, Piece morto) {
		ChessPiece p = (ChessPiece) tab.removerPeca(fin);

		p.diminuirMovimentosQ();

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

		List<Piece> list = pecasVivas.stream().filter(x -> ((ChessPiece) x).getCor() == cor)
				.collect(Collectors.toList());

		for (Piece p : list) {
			if (p instanceof Rei) {
				return (ChessPiece) p;
			}
		}
		System.out.println(ANSI_RED + "Não tem rei meu chapa");
		throw new IllegalStateException("ChessMatch - private ChessPiece rei" + ANSI_RESET);
	}

	private boolean existeCheckMate(Color cor) {
		if (!existeCheck(cor)) {
			return false;
		}

		List<Piece> list = pecasVivas.stream().filter(x -> ((ChessPiece) x).getCor() == cor)
				.collect(Collectors.toList());

		for (Piece p : list) {

			boolean[][] mP = p.movimentosPossiveis();

			for (int i = 0; i < tab.getLinhas(); i++) {
				for (int j = 0; j < tab.getColunas(); j++) {
					if (mP[i][j]) {
						Position ini = ((ChessPiece) p).getChessPosition().toPosition();
						Position fin = new Position(i, j);
						Piece pecaMorta = fazerMovimento(ini, fin);
						boolean teste = existeCheck(cor);
						desfazerMovimento(ini, fin, pecaMorta);
						if (teste == false) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private boolean existeCheck(Color cor) {
		Position posicaoRei = rei(cor).getChessPosition().toPosition();
		List<Piece> pecasInimigas = pecasVivas.stream().filter(x -> ((ChessPiece) x).getCor() == oponente(cor))
				.collect(Collectors.toList());
		for (Piece p : pecasInimigas) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	public boolean getMariele() {
		return mariele;
	}

	private Piece fazerMovimento(Position source, Position target) {
		ChessPiece p = (ChessPiece) tab.removerPeca(source);
		p.aumentarMovimentosQ();
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

		colocarNovaPeca('a', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('b', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('c', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('d', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('e', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('f', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('g', 7, new Peao(tab, Color.PRETO));
		colocarNovaPeca('h', 7, new Peao(tab, Color.PRETO));

		colocarNovaPeca('a', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('b', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('c', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('d', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('e', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('f', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('g', 2, new Peao(tab, Color.BRANCO));
		colocarNovaPeca('h', 2, new Peao(tab, Color.BRANCO));

		colocarNovaPeca('a', 1, new Torre(tab, Color.BRANCO));
		colocarNovaPeca('b', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('d', 1, new Rainha(tab, Color.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tab, Color.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tab, Color.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tab, Color.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tab, Color.BRANCO));

	}

}
