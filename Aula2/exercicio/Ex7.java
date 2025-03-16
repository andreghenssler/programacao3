package Aula2.exercicio;
import java.util.Scanner;
//Faça uma classe Java que leia a altura e o peso de uma pessoa e calcule seu IMC IMC = peso/altura²
public class Ex7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Calculandos o seu ICM");
        System.out.print("Digite a Sua altura em metros: ");
        float altura = ler.nextFloat();
        System.out.print("Digite a Sua pesp em kg: ");
        float peso = ler.nextFloat();
        double imc =  peso/Math.pow(altura,2.0);
        System.out.println("O seu IMC é de : "+ imc);
    }
}
