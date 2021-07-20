package application;

import java.util.Scanner;

import xadrez.ChessMatch;
import xadrez.ChessPiece;
import xadrez.ChessPosition;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		ChessMatch Partida = new ChessMatch();
		
		while(true) {
			UI.printBoard(Partida.getPeças());
			System.out.println();
			System.out.println();
			System.out.println("Source:");
			ChessPosition source = UI.lerPosicao(sc);
			
			System.out.println();
			System.out.println("target:");
			ChessPosition target = UI.lerPosicao(sc);
			
			ChessPiece capturedPiece = Partida.moverPecaXadrez(source, target);
			
			sc.close();
		}
	}

}
