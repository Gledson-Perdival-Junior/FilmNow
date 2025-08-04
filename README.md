# 🎬 FilmNow

**FilmNow** é uma aplicação em Java que simula um sistema de catálogo de filmes, operando totalmente via terminal. Através de menus interativos, o usuário pode visualizar, buscar, interagir e adcionar filmes à base de dados de filmes.

## ✨ Funcionalidades

- 📃 Listagem de filmes
- 🔍 Busca por título
- 🧭 Navegação simples por menus de texto

## 🛠 Tecnologias

- Java (JDK 8+)
- Orientação a Objetos
- Manipulação de arquivos com `java.io`
- Entrada de dados com `Scanner`

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/Gledson-Perdival-Junior/FilmNow.git
cd FilmNow
````   
Compile os arquivos:

````bash
javac -d bin src/filmnow/*.java
````
Execute o programa:

````bash
java -cp bin filmnow.FilmNow
````
Obs: Certifique-se de ter a JDK instalada e adicionada ao PATH.

📁 Estrutura
````bash
FilmNow/
├── src/filmnow/
│   ├── FilmNow.java       # Classe que manipula os filmes
│   ├── MainFilmNow.java   # Classe principal com o método main
│   ├── Filme.java         # Classe que representa os filmes
│   └── (outros arquivos utilitários)
├── data/                  # Arquivos de dados de filmes
├── bin/                   # Classes compiladas
````
📌 Requisitos
Java 8 ou superior

Terminal/console para interação
