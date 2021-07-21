package jogoTabuleiro;

public class Position {

	private int linha;
	private int coluna;

	public Position(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public void setPosi(Position posi) {
		this.linha = posi.getLinha();
		this.coluna = posi.getColuna();
	}

	public void setPosi(int l, int c) {
		this.linha = l;
		this.coluna = c;
	}
	
	@Override
	public String toString() {
		return "linha: " + linha + " | " + "Coluna: " + coluna;
	}

}