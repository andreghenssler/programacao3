package trabalho;
import java.util.Scanner;
import java.util.Random;

public class CERTO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para armazenar as estatísticas
        int acertosDoJogador = 0;
        int errosDoJogador = 0;
        int acertosDoComputador = 0;
        int errosDoComputador = 0;

        // Criação dos tabuleiros
        char[][] tabuleiroDoJogador = new char[10][10];
        char[][] tabuleiroDoOponente = new char[10][10];
        char[][] tabuleiroDoJogadorVisivel = new char[10][10]; // Visível para o oponente
        char[][] tabuleiroDoOponenteVisivel = new char[10][10]; // Visível para o jogador

        // Inicializa os tabuleiros com água (~)
        inicializarTabuleiro(tabuleiroDoJogador);
        inicializarTabuleiro(tabuleiroDoOponente);
        inicializarTabuleiro(tabuleiroDoJogadorVisivel);
        inicializarTabuleiro(tabuleiroDoOponenteVisivel);

        // Escolha do modo de jogo
        System.out.println("Bem-vindo ao jogo Batalha Naval!");
        int modoDeJogo;
        do {
            System.out.println("Escolha o modo de jogo: ");
            System.out.println("(1) Jogar contra o Computador");
            System.out.println("(2) Jogar contra outro jogador");
            modoDeJogo = scanner.nextInt();
        } while (modoDeJogo < 1 || modoDeJogo > 2); // Valida a entrada

        // Alocação dos navios no tabuleiro do jogador
        alocarNaviosDoJogador(tabuleiroDoJogador, scanner);

        // Alocação dos navios no tabuleiro do oponente
        if (modoDeJogo == 1) {
            alocarNaviosDoComputador(tabuleiroDoOponente);
        } else {
            alocarNaviosDoJogador(tabuleiroDoOponente, scanner);
        }

        // Início do jogo
        boolean jogoTerminado = false;
        boolean turnoDoJogador = true; // Começa com o jogador

        while (!jogoTerminado) {
            if (turnoDoJogador) {
                System.out.println("Seu tabuleiro:");
                mostrarTabuleiro(tabuleiroDoJogadorVisivel);

                System.out.println("Tabuleiro do oponente:");
                mostrarTabuleiro(tabuleiroDoOponenteVisivel);

                // Jogador ataca
                realizarJogada(tabuleiroDoOponente, tabuleiroDoOponenteVisivel, scanner, "Jogador");

                if (verificarAcerto(tabuleiroDoOponente, tabuleiroDoOponenteVisivel)) {
                    acertosDoJogador++;
                } else {
                    errosDoJogador++;
                }
            } else {
                if (modoDeJogo == 1) {
                    System.out.println("Turno do Computador...");
                    realizarJogadaComputador(tabuleiroDoJogador, tabuleiroDoJogadorVisivel);

                    if (verificarAcerto(tabuleiroDoJogador, tabuleiroDoJogadorVisivel)) {
                        acertosDoComputador++;
                    } else {
                        errosDoComputador++;
                    }
                } else {
                    System.out.println("Turno do Oponente...");
                    realizarJogada(tabuleiroDoJogador, tabuleiroDoJogadorVisivel, scanner, "Oponente");
                }
            }

            // Verifica se o jogo terminou
            jogoTerminado = verificarFimDeJogo(tabuleiroDoJogador) || verificarFimDeJogo(tabuleiroDoOponente);

            // Alterna o turno
            turnoDoJogador = !turnoDoJogador;

            // Exibe as estatísticas
            mostrarEstatisticas(acertosDoJogador, errosDoJogador, acertosDoComputador, errosDoComputador);
        }

        // Verifica quem venceu
        if (verificarFimDeJogo(tabuleiroDoOponente)) {
            System.out.println("Parabéns, você venceu!");
        } else {
            System.out.println("Você perdeu!");
        }

        System.out.println("Fim do jogo!");
    }

    // Inicializa o tabuleiro com água (~)
    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                tabuleiro[linha][coluna] = '~'; // Água
            }
        }
    }

    // Exibe o tabuleiro para o jogador
    public static void mostrarTabuleiro(char[][] tabuleiro) {
        System.out.print("  ");
        for (int coluna = 0; coluna < 10; coluna++) {
            System.out.print((char)('A' + coluna) + " "); // Colunas como letras (A-J)
        }
        System.out.println();

        for (int linha = 0; linha < 10; linha++) {
            System.out.print(linha + " "); // Linhas como números (0-9)
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }
    }

    // Verifica se uma posição é válida
    public static boolean verificarSePosicaoEValida(int linha, int coluna) {
        return linha >= 0 && linha < 10 && coluna >= 0 && coluna < 10;
    }

    // Verifica se já foi feito um ataque nessa posição
    public static boolean verificarSeJaAtacou(char[][] tabuleiro, int linha, int coluna) {
        return tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O';
    }

    // Aloca navios do jogador
    public static void alocarNaviosDoJogador(char[][] tabuleiro, Scanner scanner) {
        System.out.println("Deseja alocar os navios manualmente ou automaticamente? (M/A): ");
        char escolha;
        do {
            escolha = scanner.next().toUpperCase().charAt(0);
        } while (escolha != 'M' && escolha != 'A'); // Valida a escolha

        if (escolha == 'M') {
            // Alocação manual
            for (int tamanhoNavio = 4; tamanhoNavio >= 1; tamanhoNavio--) {
                for (int quantidadeNavios = 0; quantidadeNavios < (5 - tamanhoNavio); quantidadeNavios++) {
                    boolean navioColocado = false;
                    while (!navioColocado) {
                        System.out.println("Alocando barco de tamanho " + tamanhoNavio + "...");
                        mostrarTabuleiro(tabuleiro); // Mostra o tabuleiro atual
                        int linha, colunaNavio; // Renomeado para evitar conflito
                        do {
                            System.out.println("Digite a linha (0-9): ");
                            linha = scanner.nextInt();
                        } while (linha < 0 || linha > 9); // Valida a linha
                        char colunaLetra;
                        do {
                            System.out.println("Digite a coluna (A-J): ");
                            colunaLetra = scanner.next().toUpperCase().charAt(0);
                        } while (colunaLetra < 'A' || colunaLetra > 'J'); // Valida a coluna
                        colunaNavio = colunaLetra - 'A'; // Conversão de letra para índice
                        char direcao;
                        do {
                            System.out.println("Digite a direção (H para horizontal, V para vertical): ");
                            direcao = scanner.next().toUpperCase().charAt(0);
                        } while (direcao != 'H' && direcao != 'V'); // Valida a direção

                        if (verificarPosicao(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao)) {
                            colocarNavio(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao);
                            navioColocado = true;
                        } else {
                            System.out.println("Posição inválida. Tente novamente.");
                        }
                    }
                }
            }
        } else {
            // Alocação automática
            alocarNaviosDoComputador(tabuleiro);
        }
    }

    // Aloca navios do computador
    public static void alocarNaviosDoComputador(char[][] tabuleiro) {
        Random random = new Random();
        for (int tamanhoNavio = 4; tamanhoNavio >= 1; tamanhoNavio--) {
            for (int quantidadeNavios = 0; quantidadeNavios < (5 - tamanhoNavio); quantidadeNavios++) {
                boolean navioColocado = false;
                while (!navioColocado) {
                    int linha = random.nextInt(10);
                    int coluna = random.nextInt(10);
                    char direcao = random.nextBoolean() ? 'H' : 'V';

                    if (verificarPosicao(tabuleiro, tamanhoNavio, linha, coluna, direcao)) {
                        colocarNavio(tabuleiro, tamanhoNavio, linha, coluna, direcao);
                        navioColocado = true;
                    }
                }
            }
        }
    }

    // Verifica se a posição é válida para colocar um navio
    public static boolean verificarPosicao(char[][] tabuleiro, int tamanhoNavio, int linha, int coluna, char direcao) {
        if (direcao == 'H') {
            if (coluna + tamanhoNavio > 10) return false; // Sai do tabuleiro
            for (int i = 0; i < tamanhoNavio; i++) {
                if (tabuleiro[linha][coluna + i] != '~') return false; // Posição ocupada
            }
        } else { // Direção vertical
            if (linha + tamanhoNavio > 10) return false; // Sai do tabuleiro
            for (int i = 0; i < tamanhoNavio; i++) {
                if (tabuleiro[linha + i][coluna] != '~') return false; // Posição ocupada
            }
        }
        return true;
    }

    // Coloca um navio no tabuleiro
    public static void colocarNavio(char[][] tabuleiro, int tamanhoNavio, int linha, int coluna, char direcao) {
        if (direcao == 'H') {
            for (int i = 0; i < tamanhoNavio; i++) {
                tabuleiro[linha][coluna + i] = 'N'; // Marca o navio
            }
        } else {
            for (int i = 0; i < tamanhoNavio; i++) {
                tabuleiro[linha + i][coluna] = 'N'; // Marca o navio
            }
        }
    }

    // Realiza uma jogada (ataque)
    public static void realizarJogada(char[][] tabuleiroOponente, char[][] tabuleiroOponenteVisivel, Scanner scanner, String jogador) {
        System.out.println("É a vez de " + jogador + " atacar!");
        int linha = -1; // Inicializa com um valor inválido
        int coluna = -1; // Inicializa com um valor inválido

        // Loop para garantir entrada válida para a linha
        while (linha < 0 || linha > 9) {
            System.out.print("Digite a linha (0-9) para atacar: ");
            if (scanner.hasNextInt()) {
                linha = scanner.nextInt();
                if (linha < 0 || linha > 9) {
                    System.out.println("Valor inválido. A linha deve estar entre 0 e 9.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        // Loop para garantir entrada válida para a coluna
        while (coluna < 0 || coluna > 9) {
            System.out.print("Digite a coluna (A-J) para atacar: ");
            char colunaLetra = scanner.next().toUpperCase().charAt(0);
            coluna = colunaLetra - 'A'; // Conversão de letra para índice

            if (coluna < 0 || coluna > 9) {
                System.out.println("Valor inválido. A coluna deve estar entre A e J.");
            }
        }

        // Verifica se a posição é válida para ataque
        if (verificarSePosicaoEValida(linha, coluna) && !verificarSeJaAtacou(tabuleiroOponente, linha, coluna)) {
            if (tabuleiroOponente[linha][coluna] == 'N') {
                System.out.println("Acertou!");
                tabuleiroOponenteVisivel[linha][coluna] = 'X'; // Marca como acertado
            } else {
                System.out.println("Errou!");
                tabuleiroOponenteVisivel[linha][coluna] = 'O'; // Marca como perdido
            }
        } else {
            System.out.println("Posição inválida ou já atacada. Tente novamente.");
            realizarJogada(tabuleiroOponente, tabuleiroOponenteVisivel, scanner, jogador); // Chama novamente se a posição for inválida
        }
    }

    // Simula a jogada do computador
    public static void realizarJogadaComputador(char[][] tabuleiroJogador, char[][] tabuleiroJogadorVisivel) {
        Random random = new Random();
        int linha;
        int coluna;
        do {
            linha = random.nextInt(10);
            coluna = random.nextInt(10);
        } while (!verificarSePosicaoEValida(linha, coluna) || verificarSeJaAtacou(tabuleiroJogador, linha, coluna)); // Verifica se já atacou

        System.out.println("Computador ataca: " + linha + ", " + (char)('A' + coluna)); // Exibe onde o computador atacou
        if (tabuleiroJogador[linha][coluna] == 'N') {
            System.out.println("Computador acertou!");
            tabuleiroJogadorVisivel[linha][coluna] = 'X'; // Marca como acertado
        } else {
            System.out.println("Computador errou!");
            tabuleiroJogadorVisivel[linha][coluna] = 'O'; // Marca como perdido
        }
    }

    // Verifica se há um acerto
    public static boolean verificarAcerto(char[][] tabuleiroOponente, char[][] tabuleiroOponenteVisivel) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (tabuleiroOponente[linha][coluna] == 'N' && tabuleiroOponenteVisivel[linha][coluna] == 'X') {
                    return true; // Há um acerto
                }
            }
        }
        return false; // Não há acertos
    }

    // Verifica se o jogo acabou
    public static boolean verificarFimDeJogo(char[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (tabuleiro[linha][coluna] == 'N') {
                    return false; // Existem navios ainda
                }
            }
        }
        return true; // Todos os navios foram afundados
    }

    // Mostra as estatísticas do jogo
    public static void mostrarEstatisticas(int acertosDoJogador, int errosDoJogador, int acertosDoComputador, int errosDoComputador) {
        System.out.println("Estatísticas:");
        System.out.println("Jogador - Acertos: " + acertosDoJogador + ", Erros: " + errosDoJogador);
        System.out.println("Computador - Acertos: " + acertosDoComputador + ", Erros: " + errosDoComputador);
}
}