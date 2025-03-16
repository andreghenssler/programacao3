package Aula2.exercicio;

import java.util.Scanner;

//Escreva uma classe Java que converta metros para centímetros.
public class Ex4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o valor de Metros");
        float metros = ler.nextFloat();
        float convert = metros*100;
        System.out.println("O valor digita fica "+convert+" em CM");
    }
}
