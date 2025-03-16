package aula11;

public class Gato extends Animal{
    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    public void emitirSom() {
        System.out.println("Miau");
    }
}
