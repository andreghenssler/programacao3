package Aula2.exercicio;
import java.util.Scanner;
// Escreva um programa que leia o nome e o sobrenome de uma pessoa separadamente e mostre uma mensagem, “Bem vindo Nome Sobrenome”.
public class Ex2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o seu Nome: ");
        String nome = ler.next();
        System.out.print("Digite o seu Sobrenome: ");
        String sobrenome = ler.next();
        System.out.println("Seu nome Completo é "+nome+" "+sobrenome);
    }
}
