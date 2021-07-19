package application;

import xadrez.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pe�as) {
		
		System.out.println("  ");
		System.out.println("  ");
		
		for (int l = 0; l < pe�as.length; l++) {
			
			System.out.print("          " + (8 - l) + "  ");
			
			for (int c = 0; c < pe�as.length; c++) {
				printPeca(pe�as[l][c]);
			}
			
			System.out.println();
		}
		
		System.out.println("");
		System.out.print("             A B C D E F G H");
	}

	private static void printPeca(ChessPiece pe�a) {
		if (pe�a == null) {
			System.out.print(".");
		} else {
			System.out.print(pe�a);
		}
		System.out.print(" ");

	}

}
