package trabalho2_1;
/* Nomes: André e Felipe */
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n=== Menu de Opções ===");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Alterar Contato");
            System.out.println("3 - Deletar Contato");
            System.out.println("4 - Listar Contatos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("=== Adicionar Contato ===");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        contato.incluir(nome, telefone, email);
                        System.out.println("Contato adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.println("=== Alterar Contato ===");
                        System.out.print("ID do Contato: ");
                        int idAlterar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        String novoTelefone = scanner.nextLine();
                        System.out.print("Novo Email: ");
                        String novoEmail = scanner.nextLine();
                        contato.alterar(idAlterar, novoNome, novoTelefone, novoEmail);
                        System.out.println("Contato alterado com sucesso!");
                        break;

                    case 3:
                        System.out.println("=== Deletar Contato ===");
                        System.out.print("ID do Contato: ");
                        int idDeletar = scanner.nextInt();
                        scanner.nextLine();
                        contato.deletar(idDeletar);
                        System.out.println("Contato deletado com sucesso!");
                        break;

                    case 4:
                        System.out.println("=== Lista de Contatos ===");
                        contato.listar();
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
            }
        } while (opcao != 5);

        scanner.close();
    }
}
