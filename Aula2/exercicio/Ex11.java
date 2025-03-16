package Aula2.exercicio;
import java.util.Scanner;

// Escreva um programa que calcula a área de um triângulo
public class Ex11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a Base: ");
        float base = ler.nextFloat();
        System.out.print("Digite a Altura: ");
        float altura = ler.nextFloat();
        double area = (base*altura)/2;
        System.out.println("O Area do quadrado é de "+area+"cm");
    }
}
