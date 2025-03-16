package Aula2;

public class Exemplo2 {
    public static void main(String[] args) {
        float altura = (float) 1.9;
        double numero = Math.PI;
        System.out.println("PI: "+numero);
        int base = 5;
        int expoente = 2;
        float respo = (float) Math.pow(base,expoente);

        System.out.println("Expoente de "+base+" na "+expoente+" é "+respo);
    }
}
