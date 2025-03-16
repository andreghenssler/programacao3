package trabalho;
import java.util.Scanner;
import java.util.Random;

public class Batalha{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int acertosDoJogador = 0;
        int errosDoJogador = 0;
        int acertosDoPC = 0;
        int errosDoPC = 0;

        char[][] tabuleiroDoJogador = new char[10][10];
        char[][] tabuleiroDoAdversario = new char[10][10];
        char[][] tabuleiroDoJogadorVisivel = new char[10][10];
        char[][] tabuleiroDoAdversarioVisivel = new char[10][10];

        inicializarTabuleiro(tabuleiroDoJogador);
        inicializarTabuleiro(tabuleiroDoAdversario);
        inicializarTabuleiro(tabuleiroDoJogadorVisivel);
        inicializarTabuleiro(tabuleiroDoAdversarioVisivel);

        System.out.println("Bem-vindo ao jogo Batalha Naval!");
        int modoDeJogo;
        do {
            System.out.println("Escolha o modo de jogo: ");
            System.out.println("(1) Jogar contra o PC");
            System.out.println("(2) Jogar contra outro jogador");
            modoDeJogo = ler.nextInt();
        } while (modoDeJogo < 1 || modoDeJogo > 2);

        alocarNaviosDoJogador(tabuleiroDoJogador, ler);

        if (modoDeJogo == 1) {
            alocarNaviosDoPC(tabuleiroDoAdversario);
        } else {
            alocarNaviosDoJogador(tabuleiroDoAdversario, ler);
        }

        boolean jogoTerminado = false;
        boolean turnoDoJogador = true;

        while (!jogoTerminado) {
            if (turnoDoJogador) {
                System.out.println("Seu tabuleiro:");
                mostrarTabuleiro(tabuleiroDoJogador);
                System.out.println("Tabuleiro do adversário:");
                mostrarTabuleiro(tabuleiroDoAdversarioVisivel);

                boolean acerto = realizarJogada(tabuleiroDoAdversario, tabuleiroDoAdversarioVisivel, ler, "Jogador");

                if (acerto) {
                    acertosDoJogador++;
                } else {
                    errosDoJogador++;
                }
            } else {
                if (modoDeJogo == 1) {
                    System.out.println("Turno do PC...");
                    boolean acerto = realizarJogadaPC(tabuleiroDoJogador, tabuleiroDoJogadorVisivel);

                    if (acerto) {
                        acertosDoPC++;
                    } else {
                        errosDoPC++;
                    }
                } else {
                    System.out.println("Turno do Adversário...");
                    boolean acerto = realizarJogada(tabuleiroDoJogador, tabuleiroDoJogadorVisivel, ler, "Adversário");

                    if (acerto) {
                        acertosDoPC++;
                    } else {
                        errosDoPC++;
                    }
                }
            }

            jogoTerminado = verificarFimDeJogo(tabuleiroDoJogador) || verificarFimDeJogo(tabuleiroDoAdversario);
            mostrarEstatisticas(acertosDoJogador, errosDoJogador, acertosDoPC, errosDoPC);
            System.out.println();
            turnoDoJogador = !turnoDoJogador;
        }

        if (verificarFimDeJogo(tabuleiroDoAdversario)) {
            System.out.println("Parabéns, você venceu!");
        } else if (verificarFimDeJogo(tabuleiroDoJogador)) {
            System.out.println("Adversário venceu!");
        }

        System.out.println("Fim do jogo!");
    }

    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                tabuleiro[linha][coluna] = '~';
            }
        }
    }

    public static void mostrarTabuleiro(char[][] tabuleiro) {
        System.out.print("  ");
        for (int coluna = 0; coluna < 10; coluna++) {
            System.out.print((char) ('A' + coluna) + " ");
        }
        System.out.println();

        for (int linha = 0; linha < 10; linha++) {
            System.out.print(linha + " ");
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }
    }

    public static boolean verificarSePosicaoEValida(int linha, int coluna) {
        return linha >= 0 && linha < 10 && coluna >= 0 && coluna < 10;
    }

    public static boolean verificarSeJaAtacou(char[][] tabuleiro, int linha, int coluna) {
        return tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O';
    }

    public static void alocarNaviosDoJogador(char[][] tabuleiro, Scanner ler) {
        System.out.println("Deseja alocar os navios manualmente ou automaticamente? (M/A): ");
        char escolha;
        do {
            escolha = ler.next().toUpperCase().charAt(0);
        } while (escolha != 'M' && escolha != 'A');

        if (escolha == 'M') {
            for (int tamanhoNavio = 4; tamanhoNavio >= 1; tamanhoNavio--) {
                for (int quantidadeNavios = 0; quantidadeNavios < (5 - tamanhoNavio); quantidadeNavios++) {
                    boolean navioColocado = false;
                    while (!navioColocado) {
                        System.out.println("Alocando barco de tamanho " + tamanhoNavio + "...");
                        mostrarTabuleiro(tabuleiro);

                        int linha = -1, colunaNavio = -1;
                        char colunaLetra;
                        char direcao;

                        do {
                            System.out.print("Digite a linha (0-9): ");
                            while (!ler.hasNextInt()) {
                                System.out.println("Entrada inválida. Digite um número inteiro entre 0 e 9.");
                                ler.next();
                            }
                            linha = ler.nextInt();
                        } while (linha < 0 || linha > 9);

                        do {
                            System.out.print("Digite a coluna (A-J): ");
                            colunaLetra = ler.next().toUpperCase().charAt(0);
                            colunaNavio = colunaLetra - 'A';
                        } while (colunaNavio < 0 || colunaNavio > 9);

                        do {
                            System.out.print("Digite a direção (H para Horizontal ou V para Vertical): ");
                            direcao = ler.next().toUpperCase().charAt(0);
                        } while (direcao != 'H' && direcao != 'V');

                        if (verificarPosicao(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao)) {
                            colocarNavio(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao);
                            navioColocado = true;
                        } else {
                            System.out.println("Posição inválida, tente novamente.");
                        }
                    }
                }
            }
        } else {
            for (int tamanhoNavio = 4; tamanhoNavio >= 1; tamanhoNavio--) {
                for (int quantidadeNavios = 0; quantidadeNavios < (5 - tamanhoNavio); quantidadeNavios++) {
                    boolean navioColocado = false;
                    Random random = new Random();
                    while (!navioColocado) {
                        int linha = random.nextInt(10);
                        int colunaNavio = random.nextInt(10);
                        char direcao = random.nextBoolean() ? 'H' : 'V';

                        if (verificarPosicao(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao)) {
                            colocarNavio(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao);
                            navioColocado = true;
                        }
                    }
                }
            }
        }
    }

    public static boolean verificarPosicao(char[][] tabuleiro, int tamanhoNavio, int linha, int coluna, char direcao) {
        if (direcao == 'H') {
            if (coluna + tamanhoNavio > 10) return false;
            for (int i = 0; i < tamanhoNavio; i++) {
                if (tabuleiro[linha][coluna + i] != '~') return false;
            }
        } else {
            if (linha + tamanhoNavio > 10) return false;
            for (int i = 0; i < tamanhoNavio; i++) {
                if (tabuleiro[linha + i][coluna] != '~') return false;
            }
        }
        return true;
    }

    public static void colocarNavio(char[][] tabuleiro, int tamanhoNavio, int linha, int coluna, char direcao) {
        if (direcao == 'H') {
            for (int i = 0; i < tamanhoNavio; i++) {
                tabuleiro[linha][coluna + i] = 'N';
            }
        } else {
            for (int i = 0; i < tamanhoNavio; i++) {
                tabuleiro[linha + i][coluna] = 'N';
            }
        }
    }

    public static void alocarNaviosDoPC(char[][] tabuleiro) {
        for (int tamanhoNavio = 4; tamanhoNavio >= 1; tamanhoNavio--) {
            for (int quantidadeNavios = 0; quantidadeNavios < (5 - tamanhoNavio); quantidadeNavios++) {
                boolean navioColocado = false;
                Random random = new Random();
                while (!navioColocado) {
                    int linha = random.nextInt(10);
                    int colunaNavio = random.nextInt(10);
                    char direcao = random.nextBoolean() ? 'H' : 'V';

                    if (verificarPosicao(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao)) {
                        colocarNavio(tabuleiro, tamanhoNavio, linha, colunaNavio, direcao);
                        navioColocado = true;
                    }
                }
            }
        }
    }

    public static boolean realizarJogada(char[][] tabuleiroAdversario, char[][] tabuleiroAdversarioVisivel, Scanner ler, String jogador) {
        int linha, colunaNavio;
        char colunaLetra;

        do {
            System.out.println(jogador + ", escolha uma posição para atacar.");
            linha = -1;
            colunaNavio = -1;

            // Verifica a linha
            do {
                System.out.print("Linha (0-9): ");
                while (!ler.hasNextInt()) {
                    System.out.println("Entrada inválida. Digite um número inteiro entre 0 e 9.");
                    ler.next(); // Consome a entrada inválida
                }
                linha = ler.nextInt();
            } while (linha < 0 || linha > 9);

            // Verifica a coluna
            do {
                System.out.print("Coluna (A-J): ");
                colunaLetra = ler.next().toUpperCase().charAt(0);
                colunaNavio = colunaLetra - 'A';
            } while (colunaNavio < 0 || colunaNavio > 9);

        } while (verificarSeJaAtacou(tabuleiroAdversario, linha, colunaNavio));

        if (tabuleiroAdversario[linha][colunaNavio] == 'N') {
            System.out.println("Acertou!");
            tabuleiroAdversarioVisivel[linha][colunaNavio] = 'X';
            tabuleiroAdversario[linha][colunaNavio] = 'X';
            return true;
        } else {
            System.out.println("Errou!");
            tabuleiroAdversarioVisivel[linha][colunaNavio] = 'O';
            tabuleiroAdversario[linha][colunaNavio] = 'O';
            return false;
        }
    }

    public static boolean realizarJogadaPC(char[][] tabuleiroJogador, char[][] tabuleiroJogadorVisivel) {
        Random random = new Random();
        int linha, colunaNavio;

        do {
            linha = random.nextInt(10);
            colunaNavio = random.nextInt(10);
        } while (verificarSeJaAtacou(tabuleiroJogador, linha, colunaNavio));

        if (tabuleiroJogador[linha][colunaNavio] == 'N') {
            System.out.println("PC acertou em " + linha + (char) ('A' + colunaNavio) + "!");
            tabuleiroJogadorVisivel[linha][colunaNavio] = 'X';
            tabuleiroJogador[linha][colunaNavio] = 'X';
            return true;
        } else {
            System.out.println("PC errou em " + linha + (char) ('A' + colunaNavio) + ".");
            tabuleiroJogadorVisivel[linha][colunaNavio] = 'O';
            tabuleiroJogador[linha][colunaNavio] = 'O';
            return false;
        }
    }

    public static boolean verificarFimDeJogo(char[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (tabuleiro[linha][coluna] == 'N') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void mostrarEstatisticas(int acertosJogador, int errosJogador, int acertosPC, int errosPC) {
        System.out.println("Estatísticas:");
        System.out.println("Jogad1" +
                "or: Acertos: " + acertosJogador + ", Erros: " + errosJogador);
        System.out.println("PC: Acertos: " + acertosPC + ", Erros: " + errosPC);
    }
}

