package aula11;

public class Passaro extends Animal {
    public Passaro(String nome, int idade) {
        super(nome, idade);
    }

    public void emitirSom() {
        System.out.println("Piu-piu");
    }
}
