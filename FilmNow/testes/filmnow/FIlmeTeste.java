package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FIlmeTeste {

	private FilmNow fn;	
	
	@BeforeEach
	void preparaFilmes() {
		fn = new FilmNow();
	}

	@Test
	void testeCadastraFilmePosicaoVazia() {
		assertEquals(fn.cadastraFilme(5, "Avatar", "2009", "Dysney+"), "FILME ADICIONADO");
	}
	
	@Test
	void testaCadastraFilmePosicaoOcupada() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test
	void testaCadastraMesmoFilmeDuasVezes() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(3, "Avatar", "2009", "Disney+"), "FILME JA ADICIONADO");
	}
	
	@Test
	void testaCadastraMesmoFilmeLocaisDiferentes() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(3, "Avatar", "2009", "Popcornflix"), "FILME JA ADICIONADO");
	}
	
	@Test
	void testaCadastraFilmeNaPosicaoLimite() {
		assertEquals(fn.cadastraFilme(100, "Avatar", "2009", "Dysney+"), "FILME ADICIONADO");
	}
	
	@Test
	void testaCadastraFilmeAcimaDaPosicaoLimite() {
		assertEquals(fn.cadastraFilme(101, "Avatar", "2009", "Dysney+"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testaCadastraFilmeAbaixoDaPosicaoLimite() {
		assertEquals(fn.cadastraFilme(0, "Avatar", "2009", "Dysney+"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testaCadastraFilmeComLocalVazio() {
		assertEquals(fn.cadastraFilme(5, "20 dias em Mariupol", "2023", ""), "FILME INVALIDO");
	}
	
	@Test
	void testaCadastraFilmeComAnoVazio() {
		assertEquals(fn.cadastraFilme(5, "20 dias em Mariupol", "", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test
	void testaCadastraFilmeComNomeVazio() {
		assertEquals(fn.cadastraFilme(5, "", "2023", "Cinema"), "FILME INVALIDO");
	}
	
	@Test
	void testaDetalhaFilme() {
		fn.cadastraFilme(5, "Avatar", "2009", "Disney+");
		Filme filme = fn.getFilme(5);
		DetalhaFilme df = new DetalhaFilme(filme, 5);
		assertEquals(df.toString(), "Avatar, 2009\nDisney+");
	}
	
	@Test
	void testaDetalhaFilmeSemAnoLancamento() {
		fn.cadastraFilme(5, "20 dias em MAriupol", "", "Cinema");
		Filme filme = fn.getFilme(5);
		DetalhaFilme df = new DetalhaFilme(filme, 5);
		assertEquals(df.toString(), "20 dias em MAriupol\nCinema");
	}
	
	@Test
	void testaDetalhaFilmeEmPosicaoSemFilme() {
		Filme filme = fn.getFilme(100);
		DetalhaFilme df = new DetalhaFilme(filme, 100);
		assertEquals(df.toString(), "");
	}
	
	@Test
	void testaDetalhaFilmeEmPosicaoAbaixoDoLimite() {
		DetalhaFilme df = new DetalhaFilme(null, 0);
		assertEquals(df.toString(), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testaDetalhaFilmeEmPosicaoAcimaDoLimite() {
		DetalhaFilme df = new DetalhaFilme(null, 101);
		assertEquals(df.toString(), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testaDetalhaFilmeEmUmaHotList() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		Filme filme = fn.getFilme(1);
		fn.adicionaHotList(fn.getFilme(1), 1);
		DetalhaFilme df = new DetalhaFilme(filme, 1);
		assertEquals(df.toString(), "🔥 Avatar, 2009\nDisney+");
	}
}