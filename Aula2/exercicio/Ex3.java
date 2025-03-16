package Aula2.exercicio;
import java.util.Scanner;

//Faça uma classe Java que peça as 4 notas bimestrais e mostre a média
public class Ex3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a Nota 1: ");
        float nota1 = ler.nextFloat();

        System.out.print("Digite a Nota 2: ");
        float nota2 = ler.nextFloat();

        System.out.print("Digite a Nota 3: ");
        float nota3 = ler.nextFloat();

        System.out.print("Digite a Nota 4: ");
        float nota4 = ler.nextFloat();

        float media = ((nota1+nota2)/2 + (nota3+nota4)/2)/2;
        System.out.println("A sua Media foi: "+ media);

    }
}
