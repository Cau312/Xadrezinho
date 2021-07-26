package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.ChessPosition;
import xadrez.Color;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ChessPosition lerPosicao(Scanner sc) {
		try {
			String p = sc.nextLine();
			char c = p.charAt(0);
			int l = Integer.parseInt(p.substring(1));
			return new ChessPosition(l, c);
		} catch (RuntimeException m) {
			throw new InputMismatchException("Deu erro sei la qual foi");
		}
	}

	public static void printBoard(ChessPiece[][] pecas) {

		
		System.out.println("  ");

		for (int l = 0; l < pecas.length; l++) {

			System.out.print(ANSI_GREEN + (8 - l) + "  " + ANSI_RESET);

			for (int c = 0; c < pecas.length; c++) {
				printPeca(pecas[l][c], false);
			}

			System.out.println();
		}

		System.out.println("");
		System.out.print(ANSI_GREEN + "   A B C D E F G H" + ANSI_RESET);

	}

	public static void printBoard(ChessPiece[][] pecas, boolean[][] mP) {

		
		System.out.println("  ");

		for (int l = 0; l < pecas.length; l++) {

			System.out.print(ANSI_GREEN + (8 - l) + "  " + ANSI_RESET);

			for (int c = 0; c < pecas.length; c++) {
				printPeca(pecas[l][c], mP[l][c]);
			}

			System.out.println();
		}

		System.out.println("");
		System.out.print(ANSI_GREEN + "   A B C D E F G H" + ANSI_RESET);
	}

	public static void printMatch(ChessMatch partida, List<ChessPiece> mortinhos) {
		printBoard(partida.getPeças());
		System.out.println(" ");
		printPecasMortas(mortinhos);
		System.out.println(" ");
		System.out.println("Turno: " + partida.getTurn());
		// partida.setJogador(Color.BUG);
		if (partida.getJogador() == Color.BRANCO) {
			System.out.println("Esperando jogador " + ANSI_WHITE + partida.getJogador() + ANSI_RESET);
		} else {
			if (partida.getJogador() == Color.PRETO) {
				System.out.println("Esperando jogador " + ANSI_YELLOW + partida.getJogador() + ANSI_RESET);
			} else {
				System.out.println("Eu realmente não faço ideia como alguem consegue bugar a porra de uma cor");
				throw new RuntimeException("UI - public static void printMatch" + ANSI_RESET);
			}
		}

		if (partida.getCheck() == true) {
			System.out.println(" ");
			System.out.println("Ta em chock parceiro ?");
			System.out.println("Se vira nos 30 e se salva");
		}

	}

	private static void printPeca(ChessPiece peca, boolean back) {
		if (back == true) {
			System.out.print(ANSI_CYAN_BACKGROUND);
		}
		if (peca == null) {
			System.out.print("." + ANSI_RESET + " ");
		} else {

			if (peca.getCor() == Color.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET + " ");
			} else {
				if (peca.getCor() == Color.PRETO) {
					System.out.print(ANSI_YELLOW + peca + ANSI_RESET + " ");
				} else {
					System.out.print("Como tu bugou a cor da peça amigo ?");
					throw new RuntimeException("UI - private static void printPeca" + ANSI_RESET);
				}
			}
		}
	}

	private static void printPecasMortas(List<ChessPiece> morto) {
		List<ChessPiece> brancasM = morto.stream().filter(i -> i.getCor() == Color.BRANCO).collect(Collectors.toList());
		List<ChessPiece> pretasM = morto.stream().filter(i -> i.getCor() == Color.PRETO).collect(Collectors.toList());
		System.out.println(" ");
		System.out.println("Pecinhas Mortas ;-;");
		System.out.print(ANSI_WHITE + "Brancas: ");
		System.out.println(Arrays.toString(brancasM.toArray()) + ANSI_RESET);
		System.out.print(ANSI_YELLOW + "Pretas: ");
		System.out.println(Arrays.toString(pretasM.toArray()) + ANSI_RESET);
	}

}
