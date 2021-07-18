package application;

import xadrez.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] peças) {
		
		for (int l = 0; l < peças.length; l++) {
			
			System.out.print((8 - l) + " ");
			
			for (int c = 0; c < peças.length; c++) {
				printPeça(peças[l][c]);
			}
			
			System.out.println();
		}
		
		System.out.print("  A B C D E F G H");
	}

	private static void printPeça(ChessPiece peça) {
		if (peça == null) {
			System.out.print("#");
		} else {
			System.out.print(peça);
		}
		System.out.print(" ");

	}

}
