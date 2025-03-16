package Aula2;
import java.util.Scanner; // Ler dados dos teclado

public class Exemplo1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o seu Nome: ");
        String nome = ler.next();
        System.out.print("Qual é a sua Altura em Metros: ");
        float altura = ler.nextFloat();
        System.out.print("Qual é a sua IDADE: ");
        int idade = ler.nextInt();
        System.out.println("-----");
        System.out.println("Mostrando todas as Informações ");
        System.out.println("Seu nome: "+nome);
        System.out.println("Sua Idade: "+idade );
        System.out.println("Seu Altura: "+altura+"m");
    }
}
