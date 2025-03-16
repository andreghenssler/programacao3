package Revisao;

public class TesteVeiculos {
    public static void main(String[] args) {
        // Criando um objeto da classe Veiculo
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", 2010);

        // Criando um objeto da classe Carro
        Carro carro = new Carro("Honda", "Civic", 2020, 4);

        // Exibindo os detalhes de cada veículo
        System.out.println("Detalhes do Veículo:");
        veiculo.exibirDetalhes();

        System.out.println("Detalhes do Carro:");
        carro.exibirDetalhes();
    }
}
