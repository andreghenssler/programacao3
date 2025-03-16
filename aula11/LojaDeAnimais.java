// Classe principal
import java.util.ArrayList;
import java.util.List;

public class LojaDeAnimais {

    public static void main(String[] args) {
        // Cria uma lista de animais
        List<Animal> animais = new ArrayList<>();

        // Adiciona animais à lista
        animais.add(new Cachorro("Rex", 3));
        animais.add(new Gato("Felix", 2));
        animais.add(new Passaro("Tweety", 1));

        // Percorre a lista e chama o método emitirSom() polimorficamente
        for (Animal animal : animais) {
            System.out.print(animal.nome + " faz: ");
            animal.emitirSom();
        }
    }
}
