package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author Gledson e Eliane 
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" + 
						"(E)Exibir HotList\n" +
						"(H)Atribuir HotList\n" +
						"(R)Remover Hot\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			atribuirHotList(fn, scanner);
			break;
		case "R":
			removeHotList(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * remove os filmes que estao na hotlist
	 * 
	 * @param fn
	 * @param scanner
	 */
	private static void removeHotList(FilmNow fn,Scanner scanner) {
		System.out.println("Posição> ");
		int posicaoHotList = scanner.nextInt();
		fn.retiraHotList(posicaoHotList);
	}
	
	/**
	 * coloca os filmes na hotList
	 * 
	 * @param fn
	 * @param scanner
	 */
	private static void atribuirHotList(FilmNow fn, Scanner scanner) {
		System.out.println("Filme> ");
		int posicaoFilme = scanner.nextInt();
		System.out.println("Posição> ");
		int posicaoHot = scanner.nextInt();
		fn.adicionaHotList(fn.getFilme(posicaoFilme), posicaoHot);
		System.out.println("ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot);
	}
	
	/**
	 * exibe os filmes que estao na HotList
	 * 
	 * @param fn
	 */
	private static void exibirHotList(FilmNow fn) {
		System.out.print(fn.exibirHotList());
	}

	/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {

		Filme[] filmes = fn.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(formataFilme(i + 1, filmes[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		if (posicao <= 0 || posicao >= fn.getFilmes().length + 1) {
		    System.out.println("POSIÇÃO INVÁLIDA");
		    return;
		}
		Filme filme = fn.getFilme(posicao);
		if(filme == null) {
			return;
		}
		DetalhaFilme df = new DetalhaFilme(filme, posicao);
			System.out.println(df.toString());
	}
	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, Filme filme) {
		return posicao + " - " + filme.getNome();
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
			System.out.print("\nPosição no sistema> ");
			int posicao = scanner.nextInt();
			scanner.nextLine();
			System.out.print("\nNome> ");
			String nome = scanner.nextLine();
			System.out.print("\nAno> ");
			String ano = scanner.nextLine();
			System.out.print("\nLocal> ");
			String local = scanner.nextLine();
			System.out.println(fn.cadastraFilme(posicao, nome, ano, local));
		}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
