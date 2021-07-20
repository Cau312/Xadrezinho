package jogoTabuleiro;

public class Board {

	private int linhas;
	private int colunas;
	private Piece[][] pecas;

	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece getPeca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new BoardExeption("N existe essa posi��o eeeeee");
		}
		return pecas[linha][coluna];
	}

	public Piece getPeca(Position posi) {
		if (!posicaoExiste(posi)) {
			throw new BoardExeption("N existe essa posi��o eeeeee");
		}
		return pecas[posi.getLinha()][posi.getColuna()];
	}

	public Piece[][] getPecas() {
		return pecas;
	}

	public void colocarPeca(Piece pe�, Position posi) {
		if (pecaExiste(posi) == true) {
			throw new BoardExeption("J� existe uma pe�a mo local" + posi);
		} else {

			pecas[posi.getLinha()][posi.getColuna()] = pe�;
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
		return getPeca(posi.getLinha(), posi.getColuna()) != null;
	}

	public Piece qualPeca(Position posi) {
		return getPeca(posi.getLinha(), posi.getColuna());
	}
	
	public Piece removerPeca(Position posi) {
		if(!posicaoExiste(posi)) {
			throw new BoardExeption(" N�o fode meu bom, n existe essa posi��o");
		}
		if(getPeca(posi) == null) {
			return null;
		}
		
		Piece pec = getPeca(posi);
		pec.posi��o = null;
		pecas[posi.getLinha()][posi.getColuna()] = null;
		return pec;
	}
	

}
