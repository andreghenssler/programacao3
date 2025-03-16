package Aula1;
import java.util.Scanner;

public class Exemplo3 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        System.out.print("Digite um numero inteiro: ");

        int numero = ler.nextInt();
        System.out.println("O valor digitado foi: "+numero);

        System.out.print("Digite altura em Metros: ");

        float altura = ler.nextFloat();
        System.out.println("O valor digitado foi: "+altura);
    }
}
