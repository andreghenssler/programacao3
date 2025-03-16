package Animal;

public class TesteAnimais {
    public static void main(String[] args) {
        // Criando os animais
        Mamifero camelo = new Mamifero("Camelo", "Amarelo", "Plantas", 150, 2.0f, 4);
        Peixe tubarao = new Peixe("Tubarão", "Barbatanas e Cauda", 300, 5.0f);
        Mamifero urso = new Mamifero("Urso-do-Canadá", "Castanho", "Mel", 200, 1.5f, 4);

        // Mostrando os dados dos animais
        System.out.println("Informações do Camelo:");
        camelo.dados();
        camelo.andar(2.0f);

        System.out.println("\nInformações do Tubarão:");
        tubarao.dados();
        tubarao.nadar(5.0f);

        System.out.println("\nInformações do Urso-do-Canadá:");
        urso.dados();
        urso.andar(1.5f);
    }
}
