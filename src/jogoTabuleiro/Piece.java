package jogoTabuleiro;

public class Piece {

	protected Position posi��o;
	private Board tab;

	public Piece(Board tabu) {
		tab = tabu;
	}

	protected Board getTab() {
		return tab;
	}

	@Override
	public String toString() {
		return "Piece [pos=" + posi��o + ", tab=" + tab + "]";
	}

}
