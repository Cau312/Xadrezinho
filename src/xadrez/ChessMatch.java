package xadrez;

import java.security.InvalidParameterException;
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
	private ChessPiece vuneravelS;
	private ChessPiece promocao;

	private List<Piece> pecasVivas = new ArrayList<>();
	private List<Piece> pecasMortas = new ArrayList<>();

	public ChessMatch() {
		tab = new Board(8, 8);
		turn = 1;
		jogadorAtual = Color.BRANCO;
		inicioPartida();
	}

	public ChessPiece getPromocao() {
		return promocao;
	}

	public ChessPiece getVuneravelS() {
		return vuneravelS;
	}

	public void setVuneravelS(ChessPiece vuneravelS) {
		this.vuneravelS = vuneravelS;
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

	public ChessPiece mudarPromocao(String tPeca) {
		if (promocao == null) {
			System.out.println(ANSI_RED + "Então meu bom deu merda ai com tua promocao");
			throw new IllegalStateException("ChessMatch - public ChessPiece mudarPromocao" + ANSI_RESET);
		}
		if (!tPeca.equals("Q") && !tPeca.equals("B") && !tPeca.equals("C") && !tPeca.equals("T")) {
			return promocao;
		}

		Position pos = promocao.getChessPosition().toPosition();
		Piece p = tab.removerPeca(pos);
		pecasVivas.remove(p);

		ChessPiece newPeca = novaPeca(tPeca, promocao.getCor());
		tab.colocarPeca(newPeca, pos);
		pecasVivas.add(newPeca);

		return newPeca;

	}

	private ChessPiece novaPeca(String tipo, Color cor) {
		if (tipo.equals("B"))
			return new Bispo(tab, cor);
		else if (tipo.equals("C"))
			return new Cavalo(tab, cor);
		else if (tipo.equals("T"))
			return new Torre(tab, cor);
		else if (tipo.equals("Q"))
			return new Rainha(tab, cor);
		else
			System.out.println(ANSI_RED + "Então meu bom deu merda ai com tua promocao sei oq foi não");
		throw new InvalidParameterException("ChessMatch - private ChessPiece novaPeca" + ANSI_RESET);

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

		ChessPiece pecaMovida = (ChessPiece) tab.getPeca(fim);

		// ado a ado qm me leu é arrombado

		promocao = null;
		if (pecaMovida instanceof Peao) {
			if ((pecaMovida.getCor() == Color.BRANCO && fim.getLinha() == 0)
					|| (pecaMovida.getCor() == Color.PRETO && fim.getLinha() == 7)) {

				promocao = (ChessPiece) tab.getPeca(fim);
				promocao = mudarPromocao("Q");

			}
		}

		// ido i ido qm me leu é mau parido

		check = (existeCheck(oponente(jogadorAtual))) ? true : false;

		if (existeCheckMate(oponente(jogadorAtual))) {
			mariele = true;
		} else {
			proximoTurno();
		}

		// Area Especial

		if (pecaMovida instanceof Peao
				&& (fim.getLinha() == inicio.getLinha() - 2 || fim.getLinha() == inicio.getLinha() + 2)) {
			vuneravelS = pecaMovida;
		} else {
			vuneravelS = null;
		}

		// Fim Area Especial
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

	private void desfazerMovimento(Position source, Position target, Piece pecaCapt) {

		ChessPiece p = (ChessPiece) tab.removerPeca(target);

		p.diminuirMovimentosQ();

		tab.colocarPeca(p, source);

		if (pecaCapt != null) {
			tab.colocarPeca(pecaCapt, target);
			pecasMortas.remove(pecaCapt);
			pecasVivas.add(pecaCapt);

		}

		if (p instanceof Rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position targetT = new Position(sourceT.getLinha(), sourceT.getColuna() - 2);

			ChessPiece torre = (ChessPiece) tab.removerPeca(targetT);
			tab.colocarPeca(torre, sourceT);
			torre.diminuirMovimentosQ();
		}

		if (p instanceof Rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position targetT = new Position(sourceT.getLinha(), sourceT.getColuna() + 3);

			ChessPiece torre = (ChessPiece) tab.removerPeca(targetT);
			tab.colocarPeca(torre, sourceT);
			torre.diminuirMovimentosQ();

		}

		if (p instanceof Peao) {
			if (source.getColuna() != target.getColuna() && pecaCapt == vuneravelS) {
				ChessPiece peao = (ChessPiece) tab.removerPeca(target);
				Position peaoP;
				if (p.getCor() == Color.BRANCO) {
					peaoP = new Position(3, target.getColuna());
				} else {
					peaoP = new Position(4, target.getColuna());
				}
				tab.colocarPeca(peao, peaoP);

				pecasMortas.add(pecaCapt);
				pecasVivas.remove(pecaCapt);

			}
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

		// Area Especial Fim

		if (p instanceof Rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position targetT = new Position(sourceT.getLinha(), sourceT.getColuna() - 2);

			ChessPiece torre = (ChessPiece) tab.removerPeca(sourceT);
			tab.colocarPeca(torre, targetT);
			torre.aumentarMovimentosQ();
		}

		if (p instanceof Rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position targetT = new Position(sourceT.getLinha(), sourceT.getColuna() + 3);

			ChessPiece torre = (ChessPiece) tab.removerPeca(sourceT);
			tab.colocarPeca(torre, targetT);
			torre.aumentarMovimentosQ();

		}

		if (p instanceof Peao) {
			if (source.getColuna() != target.getColuna() && pecaCapt == null) {
				Position peaoP;
				if (p.getCor() == Color.BRANCO) {
					peaoP = new Position(target.getLinha() + 1, target.getColuna());
				} else {
					peaoP = new Position(target.getLinha() - 1, target.getColuna());
				}

				pecaCapt = tab.removerPeca(peaoP);
				pecasMortas.add(pecaCapt);
				pecasVivas.remove(pecaCapt);

			}
		}

		// Area Especial Começo

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

		// colocarNovaPeca('a', 8, new Torre(tab, Color.PRETO));
		colocarNovaPeca('b', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('c', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('d', 8, new Rainha(tab, Color.PRETO));
		colocarNovaPeca('e', 8, new Rei(tab, Color.PRETO, this));
		colocarNovaPeca('f', 8, new Bispo(tab, Color.PRETO));
		colocarNovaPeca('g', 8, new Cavalo(tab, Color.PRETO));
		colocarNovaPeca('h', 8, new Torre(tab, Color.PRETO));

		colocarNovaPeca('a', 7, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('b', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('c', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('d', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('e', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('f', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('g', 7, new Peao(tab, Color.PRETO, this));
		colocarNovaPeca('h', 7, new Peao(tab, Color.PRETO, this));

		colocarNovaPeca('a', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('b', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('c', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('d', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('e', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('f', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('g', 2, new Peao(tab, Color.BRANCO, this));
		colocarNovaPeca('h', 2, new Peao(tab, Color.BRANCO, this));

		colocarNovaPeca('a', 1, new Torre(tab, Color.BRANCO));
		/*
		 * colocarNovaPeca('b', 1, new Cavalo(tab, Color.BRANCO)); colocarNovaPeca('c',
		 * 1, new Bispo(tab, Color.BRANCO)); colocarNovaPeca('d', 1, new Rainha(tab,
		 * Color.BRANCO));
		 */
		colocarNovaPeca('e', 1, new Rei(tab, Color.BRANCO, this));
		/*
		 * colocarNovaPeca('f', 1, new Bispo(tab, Color.BRANCO)); colocarNovaPeca('g',
		 * 1, new Cavalo(tab, Color.BRANCO));
		 */
		colocarNovaPeca('h', 1, new Torre(tab, Color.BRANCO));

	}

}
