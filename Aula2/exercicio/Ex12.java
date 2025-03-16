package Aula2.exercicio;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o comprimento da cozinha (em metros): ");
        double comprimento = ler.nextDouble();

        System.out.print("Digite o largura da cozinha (em metros): ");
        double largura = ler.nextDouble();

        System.out.print("Digite o Altura da cozinha (em metros): ");
        double altura = ler.nextDouble();

        System.out.print("Digite a área total das janelas e portas (em metros quadrados): ");
        double areaJanelasPortas = ler.nextDouble();

        double areaParedes = 2 * altura * (comprimento + largura);

        // Descontar a área das janelas e portas
        double areaUtil = areaParedes - areaJanelasPortas;

        // Cada caixa de azulejos cobre 1,5 m²
        double areaPorCaixa = 1.5;

        // Calcular a quantidade de caixas necessárias
        int caixasNecessarias = (int) Math.ceil(areaUtil / areaPorCaixa);

        // Exibir o resultado
        System.out.println("Quantidade de caixas de azulejos necessárias: " + caixasNecessarias);
    }
}
