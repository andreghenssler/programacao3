package Aula2.exercicio;
import java.util.Scanner;

//Faça um Programa que pergunte quanto você ganha por hora e o número de horas
//trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês

public class Ex6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Quanto você Ganha por Hora: ");
        float ganhaHora = ler.nextFloat();
        System.out.print("Quantas horas trabalhadas: ");
        int horaTrabalha = ler.nextInt();
        float salario = ganhaHora*horaTrabalha*30;
        System.out.println("O seu Salario é de:  "+ salario);
    }
}
