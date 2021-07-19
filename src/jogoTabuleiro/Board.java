package jogoTabuleiro;

public class Board {

	private int linhas;
	private int colunas;
	private Piece[][] pe�as;

	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pe�as = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new BoardExeption("N existe essa posi��o eeeeee");
		}
		return pe�as[linha][coluna];

	}

	public Piece peca(Position posi) {
		if (!posicaoExiste(posi)) {
			throw new BoardExeption("N existe essa posi��o eeeeee");
		}
		return pe�as[posi.getLinha()][posi.getColuna()];
	}

	public Piece[][] getPecas() {
		return pe�as;
	}

	public void colocarPeca(Piece pe�, Position posi) {
		if (pecaExiste(posi) == true) {
			throw new BoardExeption("J� existe uma pe�a mo local" + posi);
		} else {

			pe�as[posi.getLinha()][posi.getColuna()] = pe�;
			pe�.posi��o = posi;
		}
	}

	public boolean posicaoExiste(int l, int c) {
		return (l >= 0 && l < linhas && c >= 0 && c < colunas);
	}

	public boolean posicaoExiste(Position posi) {
		return posicaoExiste(posi.getLinha(), posi.getColuna());
	}

	public boolean pecaExiste(Position posi) {
		if (!posicaoExiste(posi)) {
			throw new BoardExeption("N existe essa posi��o eeeeee");
		}
		return peca(posi.getLinha(), posi.getColuna()) != null;
	}

	public Piece qualPeca(Position posi) {
		return peca(posi.getLinha(), posi.getColuna());
	}

}
