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
<<<<<<< HEAD
		ChessMatch partida = new ChessMatch();
=======
		ChessMatch Partida = new ChessMatch();
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
		List<ChessPiece> mortos = new ArrayList<>();

		try {
			while (true) {

				UI.clearScreen();

<<<<<<< HEAD
				UI.printMatch(partida, mortos);
=======
				UI.printMatch(Partida, mortos);
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59
				System.out.println(" ");
				System.out.println("Mover peça na posição: ");
				ChessPosition source = UI.lerPosicao(sc);

<<<<<<< HEAD
				boolean[][] possibilidadesMov = partida.movimentosPossi(source);
				UI.clearScreen();
				UI.printBoard(partida.getPeças(), possibilidadesMov);
=======
				boolean[][] possibilidadesMov = Partida.movimentosPossi(source);
				UI.clearScreen();
				UI.printBoard(Partida.getPeças(), possibilidadesMov);
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Colocar peça da posição " + source + " na posição: ");
				ChessPosition target = UI.lerPosicao(sc);

<<<<<<< HEAD
				ChessPiece pecaCapturada = partida.moverPecaXadrez(source, target);
=======
				ChessPiece pecaCapturada = Partida.moverPecaXadrez(source, target);
>>>>>>> c97087a34e50396bc26ef76a5b031e8c6b57ab59

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
