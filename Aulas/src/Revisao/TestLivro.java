package Revisao;

public class TestLivro {
    public static void main(String[] args) {
        // Criando dois objetos da classe Livro
        Livro livro1 = new Livro(
                "Dom Quixote",
                "Miguel de Cervantes",
                1605
        );
        Livro livro2 = new Livro(
                "1984",
                "George Orwell",
                1949);

        // Exibindo os detalhes dos livros
        System.out.println("Detalhes do Livro 1:");
        livro1.exibirDetalhes();

        System.out.println("Detalhes do Livro 2:");
        livro2.exibirDetalhes();
    }
}
