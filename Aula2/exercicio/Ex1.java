package Aula2.exercicio;
import java.util.Scanner;
// Escreva uma classe Java que peça um número e então mostre a mensagem ''O número informado foi [número]''.
public class Ex1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        int numero = ler.nextInt();
        System.out.println("O número digitado foi: "+numero);

    }
}
