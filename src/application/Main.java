package application;

import java.util.Scanner;

import xadrez.ChessMatch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		ChessMatch Partida = new ChessMatch();
		UI.printBoard(Partida.getPeças());
		
		System.out.println();
		System.out.println();
	
		
		sc.close();

	}

}
