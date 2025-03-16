package Aula2.exercicio;
import java.util.Scanner;

// Escreva um programa que calcule a área e o perímetro de um quadrado
public class Ex10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a largura do quadrado cm: ");
        float lado = ler.nextFloat();
        float perimetro = lado*4;
        double area = lado*lado;
        System.out.println("O Perimetro do quadrado é de "+perimetro+"cm");
        System.out.println("O Area do quadrado é de "+area+"cm");
    }
}
