package Aula1;

public class Exemplo1 {
    public static  void  main(String[] args){
        System.out.println("Improme a mensagem com quebra de linha");
        System.out.print("Imprime sem qubra de linha \n");
        System.out.printf("Imprime o mas não quebra linha \n");

        int altura = 150;
        String nome = "Jonas";

        System.out.printf("Nome: %s tem altura: %d em cm\n",nome, altura);
        System.out.println("Nome: "+nome+" tem altura: "+altura+" em cm");
        System.out.printf("Nome: %s tem altura: %d em cm",nome, altura);

    }
}
