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
			while (!partida.getMariele()) {

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

				if (partida.getPromocao() != null) {
					System.out.println(" ");
					System.out.println("Para qual peça deseja provomer seu peão ?");
					System.out.println(" B - Bispo");
					System.out.println(" Q - Rainha");
					System.out.println(" T - Torre ");
					System.out.println(" C - Cavalo");
					String tipo = sc.nextLine().toUpperCase();

					while (!tipo.equals("Q") && !tipo.equals("B") && !tipo.equals("C") && !tipo.equals("T")) {
						System.out.println(" ");
						System.out.println("Digite Corretamente - B / Q / T / C");
						tipo = sc.nextLine().toUpperCase();
					}

					partida.mudarPromocao(tipo);
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

		UI.printMatch(partida, mortos);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("A Partida acabou meu compatriota");

	}

}
