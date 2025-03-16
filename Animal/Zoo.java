package Animal;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animais = new Animal[10];
        int totalAnimais = 0;

        while (true) {
            System.out.println("Escolha o tipo de animal para adicionar:");
            System.out.println("1 - Peixe");
            System.out.println("2 - Mamífero");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir o enter

            if (opcao == 0) {
                break;
            }

            if (totalAnimais >= 10) {
                System.out.println("Capacidade máxima de animais atingida.");
                break;
            }

            System.out.print("Digite o nome do animal: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o comprimento do animal (cm): ");
            int comprimento = scanner.nextInt();

            System.out.print("Digite a velocidade do animal (m/s): ");
            float velocidade = scanner.nextFloat();
            scanner.nextLine(); // consumir o enter

            if (opcao == 1) {
                System.out.print("Digite a característica do peixe: ");
                String caracteristica = scanner.nextLine();
                Peixe peixe = new Peixe(nome, caracteristica, comprimento, velocidade);
                animais[totalAnimais++] = peixe;

            } else if (opcao == 2) {
                System.out.print("Digite a cor do mamífero: ");
                String cor = scanner.nextLine();

                System.out.print("Digite o alimento preferido do mamífero: ");
                String alimento = scanner.nextLine();

                System.out.print("Digite o número de patas do mamífero: ");
                int patas = scanner.nextInt();
                scanner.nextLine(); // consumir o enter

                Mamifero mamifero = new Mamifero(nome, cor, alimento, comprimento, velocidade, patas);
                animais[totalAnimais++] = mamifero;
            }
        }

        System.out.println("\nAnimais no zoológico:");
        for (int i = 0; i < totalAnimais; i++) {
            System.out.println("----------------------------");
            animais[i].dados();
        }
    }
}
