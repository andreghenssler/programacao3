package Aula2.exercicio;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura das informações
        System.out.print("Digite a marcação do odômetro no início do dia (Km): ");
        double odometroInicio = scanner.nextDouble();

        System.out.print("Digite a marcação do odômetro no final do dia (Km): ");
        double odometroFim = scanner.nextDouble();

        System.out.print("Digite o número de litros de combustível gasto: ");
        double litrosGastos = scanner.nextDouble();

        System.out.print("Digite o valor total recebido dos passageiros (R$): ");
        double valorRecebido = scanner.nextDouble();

        // Preço do combustível
        double precoCombustivel = 6.15;

        // Cálculo da distância percorrida
        double distanciaPercorrida = odometroFim - odometroInicio;

        // Cálculo da média de consumo (Km/L)
        double mediaConsumo = distanciaPercorrida / litrosGastos;

        // Cálculo do custo do combustível
        double custoCombustivel = litrosGastos * precoCombustivel;

        // Cálculo do lucro líquido
        double lucroLiquido = valorRecebido - custoCombustivel;

        // Exibição dos resultados
        System.out.println("Média de consumo (Km/L): " + mediaConsumo);
        System.out.println("Lucro líquido do dia (R$): " + lucroLiquido);
    }
}
