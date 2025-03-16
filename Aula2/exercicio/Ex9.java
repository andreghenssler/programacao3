package Aula2.exercicio;
import java.util.Scanner;

// Escreva uma classe Java que leia e imprima a soma e a multiplicação de dois números.
public class Ex9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int nota1 = ler.nextInt();
        System.out.print("Digite outro numero inteiro: ");
        int nota2 = ler.nextInt();
        int soma = nota2+nota1;
        int multiplicacao = nota1*nota2;
        System.out.println("A Soma é de "+ soma);
        System.out.println("A multiplicacao "+ multiplicacao);
    }
}
