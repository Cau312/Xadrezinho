package jogoTabuleiro;

public class Piece {

	protected Position posição;
	private Board tab;

	public Piece(Board tabu) {
		tab = tabu;
	}

	protected Board getTab() {
		return tab;
	}

	@Override
	public String toString() {
		return "Piece [pos=" + posição + ", tab=" + tab + "]";
	}

}
