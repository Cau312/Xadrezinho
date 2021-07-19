package jogoTabuleiro;

public class Board {

	private int linhas;
	private int colunas;
	private Piece[][] peças;

	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new BoardExeption("N existe essa posição eeeeee");
		}
		return peças[linha][coluna];

	}

	public Piece peca(Position posi) {
		if (!posicaoExiste(posi)) {
			throw new BoardExeption("N existe essa posição eeeeee");
		}
		return peças[posi.getLinha()][posi.getColuna()];
	}

	public Piece[][] getPecas() {
		return peças;
	}

	public void colocarPeca(Piece peç, Position posi) {
		if (pecaExiste(posi) == true) {
			throw new BoardExeption("Já existe uma peça mo local" + posi);
		} else {

			peças[posi.getLinha()][posi.getColuna()] = peç;
			peç.posição = posi;
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
			throw new BoardExeption("N existe essa posição eeeeee");
		}
		return peca(posi.getLinha(), posi.getColuna()) != null;
	}

	public Piece qualPeca(Position posi) {
		return peca(posi.getLinha(), posi.getColuna());
	}

}
