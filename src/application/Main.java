package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.ChessPosition;
import xadrez.Color;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String ANSI_WHITE = "\u001B[37m";
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		
		Scanner sc = new Scanner(System.in);

		ChessMatch Partida = new ChessMatch();
		
		try {
		while(true) {
			
			UI.clearScreen();
			
			UI.printBoard(Partida.getPeças());
			System.out.println();
			System.out.println();
			System.out.println("Source:");
			ChessPosition source = UI.lerPosicao(sc);
			
			System.out.println();
			System.out.println("target:");
			ChessPosition target = UI.lerPosicao(sc);
			
			ChessPiece pecaCapturada = Partida.moverPecaXadrez(source, target);
			
			if(pecaCapturada != null) {
				if(pecaCapturada.getCor() == Color.BRANCO) {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(ANSI_WHITE + "          [" + pecaCapturada + "]" + ANSI_RESET);
				}else{
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(ANSI_BLACK + "          [" + pecaCapturada + "]" + ANSI_RESET);
						}
			}
		}
		}catch(ChessException m){
			System.out.println(m.getMessage());
			sc.nextLine();
		}catch(InputMismatchException o){
			System.out.println(o.getMessage());
			sc.nextLine();
		}catch(RuntimeException n){
			System.out.println(n.getMessage());
			sc.nextLine();
		}
	}

	
}
