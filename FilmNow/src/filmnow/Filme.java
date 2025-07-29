package filmnow;

import java.util.Objects;

public class Filme {
	private String nome;
	private String ano;
	private String local;
	private boolean inHotList;
	
	/**
	 * Construtor de filme
	 * 
	 * @param nome
	 * @param ano
	 * @param local
	 */
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		}
	
	public boolean getInHotList() {
		return inHotList;
	}
	
	public void setInHotList(boolean in) {
		this.inHotList = in;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public String getAno() {
		return this.ano;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Filme other = (Filme) o;
		return ano == other.ano && Objects.equals(nome, other.nome);
	}
}
