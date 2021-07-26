package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.ChessPosition;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ChessMatch partida = new ChessMatch();
		List<ChessPiece> mortos = new ArrayList<>();

		try {
			while (true) {

				UI.clearScreen();

				UI.printMatch(partida, mortos);
				System.out.println(" ");
				System.out.println("Mover peça na posição: ");
				ChessPosition source = UI.lerPosicao(sc);

				boolean[][] possibilidadesMov = partida.movimentosPossi(source);
				UI.clearScreen();
				UI.printBoard(partida.getPeças(), possibilidadesMov);

				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Colocar peça da posição " + source + " na posição: ");
				ChessPosition target = UI.lerPosicao(sc);

				ChessPiece pecaCapturada = partida.moverPecaXadrez(source, target);

				if (pecaCapturada != null) {
					mortos.add(pecaCapturada);
				}

			}

		} catch (ChessException m) {
			System.out.println(m.getMessage());
			sc.nextLine();
		} catch (InputMismatchException o) {
			System.out.println(o.getMessage());
			sc.nextLine();
		} catch (RuntimeException n) {
			System.out.println(n.getMessage());
			sc.nextLine();
		}
	}

}
