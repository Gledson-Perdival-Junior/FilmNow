package filmnow;

public class DetalhaFilme {
	private Filme filme;
	private int posicao;
	
	/**
	 * constrtutor do detalha filme
	 * 
	 * @param filme
	 * @param posicao
	 */
	public DetalhaFilme(Filme filme, int posicao) {
		this.filme = filme;
		this.posicao = posicao;
	}
	
	public String toString() {
		if (posicao <= 0 || posicao >= 101) {
		    return "POSIÇÃO INVÁLIDA";
		}
		if(filme == null) {
			return "";
		}
		if(filme.getAno().trim() == "") {
			return this.filme.getNome() + "\n" + this.filme.getLocal();
		}
		if(filme.getInHotList()) {
			return "🔥 " + this.filme.getNome() + ", " + this.filme.getAno() + "\n" + this.filme.getLocal();
		}
		return this.filme.getNome() + ", " + this.filme.getAno() + "\n" + this.filme.getLocal();
		
	}
}