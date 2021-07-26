package jogoTabuleiro;

public abstract class Piece {

	protected Position posição;
	private Board tab;

	public Piece(Board tabu) {
		tab = tabu;
	}

	protected Board getBoard() {
		return tab;
	}

	@Override
	public String toString() {
		return "Piece [pos=" + posição + ", tab=" + tab + "]";
	}

	public abstract boolean[][] movimentosPossiveis();

	public boolean movimentoPossivel(Position posi) {
		return movimentosPossiveis()[posi.getLinha()][posi.getColuna()];
	}

	public void imprimirPossi() {
		System.out.println(movimentosPossiveis());
	}

	public boolean existePossibilidade() {
		boolean[][] monke = movimentosPossiveis();
		for (int i = 0; i < monke.length; i++) {
			for (int x = 0; x < monke.length; x++) {
				if (monke[i][x] == true) {
					return true;
				}
			}
		}
		return false;
	}
}
