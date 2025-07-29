package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	private Filme[] hotList = new Filme[10];
	
	/**
	 * retira o filme solicitado da hotlist
	 * 
	 * @param posicaoHotList
	 * @return
	 */
	public boolean retiraHotList(int posicaoHotList){
		if(this.hotList[posicaoHotList - 1] == null) {
			return true;
		}
		if(this.hotList[posicaoHotList -1] != null) {
			hotList[posicaoHotList - 1] = null;
			return true;
		}
		return false;
	}
	
	/**
	 * adiciona um filme a hotList
	 * 
	 * @param filme
	 * @param posicaoHotList
	 * @return
	 */
	public boolean adicionaHotList(Filme filme, int posicaoHotList) {
		if(filme.getInHotList() == true) {
			return false;
		}
		if(this.hotList[posicaoHotList - 1] != null) {
			hotList[posicaoHotList - 1].setInHotList(false);
			hotList[posicaoHotList - 1] = filme;
			filme.setInHotList(true);
		}
		if(this.hotList[posicaoHotList - 1] == null) {
			hotList[posicaoHotList - 1] = filme;
			filme.setInHotList(true);
		}
		return true;
	}
	
	/**
	 * verifica se o filme solicitado esta na hotList
	 * 
	 * @param posicao
	 * @return
	 */
	public boolean isInHot(int posicao) {
		if(this.hotList[posicao] != null) {
			return this.hotList[posicao].getInHotList();
		}
		return false;
	}
	
	/**
	 * mostra todos os filmes que estao na hotList
	 * 
	 * @return
	 */
	public String exibirHotList() {
		String retorno = "";
		for(int i = 0; i < hotList.length; i++) { 
			if(hotList[i] != null) {
				retorno += (i + 1) + " - " + hotList[i].getNome() + ", " + hotList[i].getAno() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public Filme getFilme(int posicao) {
		return this.filmes[posicao - 1];
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		if(nome.trim() == "") {
			return "FILME INVALIDO";
		}
		
		if(local.trim() == "") {
			return "FILME INVALIDO";
		}
		
		if(posicao <= 0 || posicao >= 101) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		Filme filme = new Filme(nome, ano ,local);
		
		for(int i = 0; i < this.filmes.length; i++) {
			if(this.filmes[i] != null && this.filmes[i].equals(filme)) {
				return "FILME JA ADICIONADO";
			}
		}
		this.filmes[posicao - 1] = filme;
		return "FILME ADICIONADO";
	}
}