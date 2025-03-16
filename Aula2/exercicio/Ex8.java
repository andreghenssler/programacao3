package Aula2.exercicio;

import java.util.Scanner;
public class Ex8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a Temperatura em Fahrenheit: ");
        float temp = ler.nextFloat();
        float C = (5 * (temp-32) / 9);
        System.out.println("A temperatura de "+temp+"ºF é em Celcius: "+C+"ºC");
    }
}

