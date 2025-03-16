package Aula2.exercicio;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura das informações
        System.out.print("Digite o comprimento da pista (em metros): ");
        double comprimentoPista = scanner.nextDouble();

        System.out.print("Digite o número total de voltas a serem percorridas no grande prêmio: ");
        int totalVoltas = scanner.nextInt();

        System.out.print("Digite o número de reabastecimentos desejados: ");
        int reabastecimentos = scanner.nextInt();

        System.out.print("Digite o consumo de combustível do carro (em Km/L): ");
        double consumoCombustivel = scanner.nextDouble();

        // Cálculo do número de voltas até o primeiro reabastecimento
        int voltasPorReabastecimento = totalVoltas / (reabastecimentos + 1);

        // Cálculo da distância total até o primeiro reabastecimento (em Km)
        double distanciaTotal = (voltasPorReabastecimento * comprimentoPista) / 1000.0;

        // Cálculo do número mínimo de litros necessários
        double litrosNecessarios = distanciaTotal / consumoCombustivel;

        // Exibição do resultado
        System.out.println("Número mínimo de litros necessários para percorrer até o primeiro reabastecimento: " + litrosNecessarios);
    }
}
