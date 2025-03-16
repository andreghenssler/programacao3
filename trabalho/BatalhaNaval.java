import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    static final int MAPA_TAMANHO = 10;
    static char[][] mapaJogador = new char[MAPA_TAMANHO][MAPA_TAMANHO];
    static char[][] mapaPC = new char[MAPA_TAMANHO][MAPA_TAMANHO];
    static char[][] mapaAtaqueJogador = new char[MAPA_TAMANHO][MAPA_TAMANHO];
    static char[][] mapaAtaquePC = new char[MAPA_TAMANHO][MAPA_TAMANHO];
    static final char[] BARCOS = {'A', 'B','C','D'};
    static final int[] TAMANHOS_BARCOS = {4, 3, 2, 1};
    static final char[] COLUNAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarMapa(mapaJogador);
        inicializarMapa(mapaPC);
        inicializarMapa(mapaAtaqueJogador);
        inicializarMapa(mapaAtaquePC);

        System.out.println("Deseja jogar contra o Computador (C) ou outro Jogador (J)?");
        String modo = scanner.next().toUpperCase();

        System.out.println("Alocação dos barcos - Jogador 1");
        if (escolherModoDeAlocacao(scanner)) {
            alocacaoManual(mapaJogador, scanner);
        } else {
            alocacaoAutomatica(mapaJogador);
        }

        if (modo.equals("J")) {
            System.out.println("Alocação dos barcos - Jogador 2");
            if (escolherModoDeAlocacao(scanner)) {
                alocacaoManual(mapaPC, scanner);
            } else {
                alocacaoAutomatica(mapaPC);
            }
        } else {
            alocacaoAutomatica(mapaPC);
        }

        System.out.println("Alocação concluída! O jogo pode começar.");

        boolean fimDeJogo = false;
        boolean turnoJogador = true;

        while (!fimDeJogo) {
            if (turnoJogador) {
                exibirMapaAtaque(mapaAtaqueJogador);
                fimDeJogo = atacar(scanner, mapaPC, mapaAtaqueJogador, "Jogador");
            } else {
                fimDeJogo = atacarComputador(mapaJogador, mapaAtaquePC);
            }
            turnoJogador = !turnoJogador;
        }

        if (turnoJogador) {
            System.out.println("Jogador 2 venceu!");
        } else {
            System.out.println("Jogador 1 venceu!");
        }

        scanner.close();
    }

    public static void inicializarMapa(char[][] mapa) {
        for (int i = 0; i < MAPA_TAMANHO; i++) {
            for (int j = 0; j < MAPA_TAMANHO; j++) {
                mapa[i][j] = '-';
            }
        }
    }

    public static boolean escolherModoDeAlocacao(Scanner scanner) {
        System.out.println("Deseja alocar os barcos manualmente? (S/N)");
        return scanner.next().equalsIgnoreCase("S");
    }

    public static void exibirMapa(char[][] mapa) {
        System.out.print("  ");
        for (char letra : COLUNAS) {
            System.out.print(letra + " ");
        }
        System.out.println();
        for (int i = 0; i < MAPA_TAMANHO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < MAPA_TAMANHO; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void exibirMapaAtaque(char[][] mapa) {
        System.out.println("Mapa de ataque:");
        exibirMapa(mapa);
    }

    public static boolean posicaoValida(char[][] mapa, int linha, int coluna, int tamanho, char orientacao) {
        if (orientacao == 'H') {
            if (coluna + tamanho > MAPA_TAMANHO) return false;
            for (int i = 0; i < tamanho; i++) {
                if (mapa[linha][coluna + i] != '-') return false;
            }
        } else {
            if (linha + tamanho > MAPA_TAMANHO) return false;
            for (int i = 0; i < tamanho; i++) {
                if (mapa[linha + i][coluna] != '-') return false;
            }
        }
        return true;
    }

    public static void alocarBarco(char[][] mapa, int linha, int coluna, int tamanho, char barco, char orientacao) {
        if (orientacao == 'H') {
            for (int i = 0; i < tamanho; i++) {
                mapa[linha][coluna + i] = barco;
            }
        } else {
            for (int i = 0; i < tamanho; i++) {
                mapa[linha + i][coluna] = barco;
            }
        }
    }

    public static void alocacaoManual(char[][] mapa, Scanner scanner) {
        for (int i = 0; i < BARCOS.length; i++) {
            char barco = BARCOS[i];
            int tamanho = TAMANHOS_BARCOS[i];

            for (int j = 0; j < (5 - tamanho); j++) {
                while (true) {
                    exibirMapa(mapa);
                    System.out.println("Alocando barco de " + tamanho + " espaços (" + barco + ")");
                    System.out.print("Escolha a linha (0-9): ");
                    int linha = scanner.nextInt();
                    System.out.print("Escolha a coluna (A-J): ");
                    char colunaChar = scanner.next().toUpperCase().charAt(0);
                    int coluna = colunaChar - 'A';
                    System.out.print("Escolha a orientação (H para Horizontal, V para Vertical): ");
                    char orientacao = scanner.next().toUpperCase().charAt(0);

                    if (coluna >= 0 && coluna < MAPA_TAMANHO && posicaoValida(mapa, linha, coluna, tamanho, orientacao)) {
                        alocarBarco(mapa, linha, coluna, tamanho, barco, orientacao);
                        break;
                    } else {
                        System.out.println("Posição inválida. Tente novamente.");
                    }
                }
            }
        }
    }

    public static void alocacaoAutomatica(char[][] mapa) {
        Random random = new Random();
        for (int i = 0; i < BARCOS.length; i++) {
            char barco = BARCOS[i];
            int tamanho = TAMANHOS_BARCOS[i];

            for (int j = 0; j < (5 - tamanho); j++) {
                while (true) {
                    int linha = random.nextInt(MAPA_TAMANHO);
                    int coluna = random.nextInt(MAPA_TAMANHO);
                    char orientacao = random.nextBoolean() ? 'H' : 'V';

                    if (posicaoValida(mapa, linha, coluna, tamanho, orientacao)) {
                        alocarBarco(mapa, linha, coluna, tamanho, barco, orientacao);
                        break;
                    }
                }
            }
        }
    }

    public static boolean atacar(Scanner scanner, char[][] mapaOponente, char[][] mapaAtaque, String jogador) {
        while (true) {
            System.out.println(jogador + ", escolha as coordenadas para atacar!");
            System.out.print("Linha (0-9): ");
            int linha = scanner.nextInt();
            System.out.print("Coluna (A-J): ");
            char colunaChar = scanner.next().toUpperCase().charAt(0);
            int coluna = colunaChar - 'A';

            if (linha < 0 || linha >= MAPA_TAMANHO || coluna < 0 || coluna >= MAPA_TAMANHO) {
                System.out.println("Coordenadas inválidas. Tente novamente.");
                continue;
            }

            if (mapaAtaque[linha][coluna] != '-') {
                System.out.println("Você já atacou essa posição. Tente novamente.");
                continue;
            }

            if (mapaOponente[linha][coluna] != '-') {
                System.out.println("Acertou!");
                mapaAtaque[linha][coluna] = 'X';  // Marca o acerto
                mapaOponente[linha][coluna] = 'X';  // Marca o acerto no mapa do oponente
            } else {
                System.out.println("Errou.");
                mapaAtaque[linha][coluna] = 'O';  // Marca o erro
            }

            break;
        }

        return verificarFimDeJogo(mapaOponente);
    }

    /*public static boolean atacarComputador(char[][] mapaJogador, char[][] mapaAtaquePC) {
        Random random = new Random();
        int linha, coluna;

        while (true) {
            linha = random.nextInt(MAPA_TAMANHO);
            coluna = random.nextInt(MAPA_TAMANHO);

            if (mapaAtaquePC[linha][coluna] == '-') {
                break;
            }
        }

        System.out.println("O computador atacou na posição " + linha + COLUNAS[coluna]);

        if (mapaJogador[linha][coluna] != '-') {
            System.out.println("O computador acertou!");
            mapaAtaquePC[linha][coluna] = 'X';  // Marca o acerto
            mapaJogador[linha][coluna] = 'X';   // Marca o acerto no mapa do jogador
        } else {
            System.out.println("O computador errou.");
            mapaAtaquePC[linha][coluna] = 'O';  // Marca o erro
        }

        return verificarFimDeJogo(mapaJogador);
    }*/
    public static boolean atacarComputador(char[][] mapaJogador, char[][] mapaAtaquePC) {
        Random random = new Random();
        int linha, coluna;

        // Escolhe uma posição não atacada ainda
        while (true) {
            linha = random.nextInt(MAPA_TAMANHO);
            coluna = random.nextInt(MAPA_TAMANHO);

            if (mapaAtaquePC[linha][coluna] == '-') {
                break;
            }
        }

        // Exibe a posição de ataque do computador
        System.out.println("O computador atacou na posição: Linha " + linha + ", Coluna " + COLUNAS[coluna]);

        // Verifica se o ataque foi em um barco ou em uma posição vazia
        if (mapaJogador[linha][coluna] != '-') {
            System.out.println("O computador acertou!");
            mapaAtaquePC[linha][coluna] = 'X';  // Marca o acerto
            mapaJogador[linha][coluna] = 'X';   // Marca o acerto no mapa do jogador
        } else {
            System.out.println("O computador errou.");
            mapaAtaquePC[linha][coluna] = 'O';  // Marca o erro
        }

        return verificarFimDeJogo(mapaJogador);
    }


    public static boolean verificarFimDeJogo(char[][] mapa) {
        for (int i = 0; i < MAPA_TAMANHO; i++) {
            for (int j = 0; j < MAPA_TAMANHO; j++) {
                if (mapa[i][j] != '-' && mapa[i][j] != 'X') {
                    return false;  // Ainda há barcos não destruídos
                }
            }
        }
        return true;  // Todos os barcos foram destruídos
    }
}
