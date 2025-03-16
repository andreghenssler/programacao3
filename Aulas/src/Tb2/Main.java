package Tb2;
/*
* Andre e Felipe
* */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("localhost", "3306", "aulas", "root", "");
        Connection conexao = banco.obterConexao();

        if (!banco.conectado()) {
            System.out.println("Erro ao conectar ao banco: " + banco.obterMensagemErro());
            return;
        }

        Contato contato = new Contato(conexao);
        int opcao;

        do {
            System.out.println("\n=== Menu de Contatos ===");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Atualizar Contato");
            System.out.println("3 - Deletar Contato");
            System.out.println("4 - Listar Contatos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("===== Cadastrar =====");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        contato.setNome(nome);
                        contato.setTelefone(telefone);
                        contato.setEMail(email);
                        contato.gravarContato();
                        System.out.println("Contato adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.println("===== Atualizar =====");
                        System.out.print("ID do Contato: ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        String novoTelefone = scanner.nextLine();
                        System.out.print("Novo Email: ");
                        String novoEmail = scanner.nextLine();
                        contato.setIdContato(idAtualizar);
                        contato.setNome(novoNome);
                        contato.setTelefone(novoTelefone);
                        contato.setEMail(novoEmail);
                        contato.atualizarContato();
                        System.out.println("Contato atualizado com sucesso!");
                        break;

                    case 3:
                        System.out.println("===== Deletar =====");
                        System.out.print("ID do Contato: ");
                        int idDeletar = scanner.nextInt();
                        if (contato.deletarContato(idDeletar)) {
                            System.out.println("Contato deletado com sucesso!");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;

                    case 4:
                        System.out.println("===== Mostrar Lista =====");
                        List<Contato> contatos = contato.obterListaContato();
                        for (Contato c : contatos) {
                            System.out.println(c);
                            System.out.println("--------------------------");
                        }
                        break;

                    case 5:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.err.println("Erro no banco de dados: " + e.getMessage());
            }
        } while (opcao != 5);

        banco.encerraConexao();
        scanner.close();
    }
}
