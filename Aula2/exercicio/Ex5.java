package Aula2.exercicio;
import java.util.Scanner;
//Faça um programa em Java que calcule a área de um círculo
public class Ex5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite um valor para o Raio: ");
        float raio = ler.nextFloat();
        double calculoCirculo = (float) Math.PI*Math.pow(raio,2.0);

        System.out.println("O Raio do circulo é: "+calculoCirculo);
    }
}
