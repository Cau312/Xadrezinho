package jogoTabuleiro;

public class Board {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
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
			System.out.println(ANSI_RED + "N existe essa posição eeeeee");
			throw new BoardExeption("Board - public Piece getPeca" + ANSI_RESET);
		}
		return pecas[linha][coluna];
	}

	public Piece getPeca(Position posi) {
		if (!posicaoExiste(posi)) {
			System.out.println(ANSI_RED + "N existe essa posição eeeeee");
			throw new BoardExeption("Board - public Piece getPeca" + ANSI_RESET);
		}
		return pecas[posi.getLinha()][posi.getColuna()];
	}

	public Piece[][] getPecas() {
		return pecas;
	}

	public void colocarPeca(Piece peç, Position posi) {
		if (pecaExiste(posi) == true) {
			System.out.println(ANSI_RED + "Já existe uma peça mo local" + posi);
			throw new BoardExeption("Board - public void colocarPeca" + ANSI_RESET);
		} else {

			pecas[posi.getLinha()][posi.getColuna()] = peç;
			peç.posição = posi;
		}
	}

	public boolean posicaoExiste(int l, int c) {
		return l >= 0 && l < linhas && c >= 0 && c < colunas;
	}

	public boolean posicaoExiste(Position posi) {
		return posicaoExiste(posi.getLinha(), posi.getColuna());
	}

	public boolean pecaExiste(Position posi) {
		if (!posicaoExiste(posi)) {
			System.out.println(ANSI_RED + "N existe essa posição eeeeee");
			throw new BoardExeption("Board - public boolean pecaExiste" + ANSI_RESET);
		}
		return getPeca(posi) != null;
	}

	public Piece qualPeca(Position posi) {
		return getPeca(posi.getLinha(), posi.getColuna());
	}

	public Piece removerPeca(Position posi) {
		if (!posicaoExiste(posi)) {
			System.out.println(ANSI_RED + "");
			throw new BoardExeption("Não fode meu bom, n existe essa posição" + ANSI_RESET);
		}
		if (getPeca(posi) == null) {
			return null;
		}

		Piece pec = getPeca(posi);
		pec.posição = null;
		pecas[posi.getLinha()][posi.getColuna()] = null;
		return pec;
	}

}
