package Revisao;
/*
Crie uma classe chamada Livro com os seguintes atributos:

titulo (String)
autor (String)
anoPublicacao (int)
Implemente:

Um construtor para inicializar todos os atributos.
Métodos getters e setters para cada atributo.
Um método chamado exibirDetalhes que imprime as informações do livro no console.
Pergunta: Crie um programa para testar a classe Livro, criando dois objetos e chamando o método exibirDetalhes.

*/
public class Livro {
    private String titulo ;
    private String autor;
    private int anoPublicacao ;

    public Livro  (String titulo, String autor, int anoPublicacao ){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao  = anoPublicacao ;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // Metodo para exibir detalhes do livro
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println();
    }
}
