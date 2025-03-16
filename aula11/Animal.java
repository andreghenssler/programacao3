// Classe base Animal
public class Animal {
    protected String nome;
    protected int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método abstrato que será implementado pelas subclasses
    public void emitirSom();
}
